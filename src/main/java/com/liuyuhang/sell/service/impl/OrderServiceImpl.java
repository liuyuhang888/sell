package com.liuyuhang.sell.service.impl;

import com.liuyuhang.sell.converter.OrderMasterToOrderDtoConverter;
import com.liuyuhang.sell.dataobject.OrderDetail;
import com.liuyuhang.sell.dataobject.OrderMaster;
import com.liuyuhang.sell.dataobject.ProductInfo;
import com.liuyuhang.sell.dto.CartDTO;
import com.liuyuhang.sell.dto.OrderDto;
import com.liuyuhang.sell.enums.OrderStatusEnum;
import com.liuyuhang.sell.enums.PayStatusEnum;
import com.liuyuhang.sell.enums.ResultEnum;
import com.liuyuhang.sell.exception.SellException;
import com.liuyuhang.sell.repository.OrderDetailRepository;
import com.liuyuhang.sell.repository.OrderMasterRepository;
import com.liuyuhang.sell.service.OrderService;
import com.liuyuhang.sell.service.ProductService;
import com.liuyuhang.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 14:39
 * @Description:
 */
@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    WebSocket webSocket;

    @Override
    public OrderDto create(OrderDto orderDto) {
        //初始生成订单id
        String orderId = KeyUtil.genUniqueKey();
        //初始化总金额为0
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //1.  查询商品（数量，价格）
        for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {

            //根据前端得到的产品编号查询出产品的全部信息
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //2.通过产品全部信息得到每个产品的单价，计算订单总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //3. 写入订单数据库
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            //拷贝相应属性
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);

            //发生websocket消息
            webSocket.sendMessage(orderDetail.getOrderId());

        }

        OrderMaster orderMaster = new OrderMaster();

        //注意，拷贝数据时，如果值是null也会被拷贝进去
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderDto.setOrderId(orderMaster.getOrderId());
        orderMasterRepository.save(orderMaster);
        //4. 扣库存
        List<CartDTO> cartDTOList = orderDto
                .getOrderDetailList()
                .stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());

        productService.decreaseStock(cartDTOList);

        return orderDto;
    }

    @Override
    public OrderDto findOne(String OderId) {

        OrderMaster one = orderMasterRepository.findOne(OderId);
        if (one == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(OderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        OrderDto dto = new OrderDto();
        BeanUtils.copyProperties(one, dto);
        dto.setOrderDetailList(orderDetailList);

        return dto;
    }

    @Override
    public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
        //将orderMaster转换为orderDto
        List<OrderDto> orderDtoList = OrderMasterToOrderDtoConverter.convert(orderMasterPage.getContent());
        //添加订单详情信息
       /* for (OrderDto orderDto : orderDtoList) {
            orderDto.setOrderDetailList(orderDetailRepository.findByOrderId(orderDto.getOrderId()));
        }  详情信息专门在查询详情中添加   */

        Page<OrderDto> orderDtoPage = new PageImpl<OrderDto>(orderDtoList, pageable, orderMasterPage.getTotalElements());
        return orderDtoPage;
    }

    @Override
    @Transactional
    public OrderDto cancel(OrderDto orderDto) {
        OrderMaster orderMaster = new OrderMaster();

        //判断订单状态

        if (!orderDto.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.info("【取消订单】 订单状态不正确 orderId = {} ,orderStatus = {} ", orderDto.getOrderId(), orderDto.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改订单状态
        orderDto.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDto, orderMaster);
        OrderMaster result = orderMasterRepository.save(orderMaster);
        if (result == null) {
            log.info("【取消订单】 更新失败 orderMaster= {}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FALL);
        }
        //返回库存
        if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())) {
            log.info("【取消订单】订单中无商品详情，orderDTO={}", orderDto.getOrderId());
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<CartDTO> cartDTOList = orderDto.getOrderDetailList().stream().map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productService.increaseStock(cartDTOList);
        //如果已经支付，退款
        if (orderDto.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            //TODO
        }


        return orderDto;
    }

    @Override
    @Transactional
    public OrderDto finish(OrderDto orderDto) {
        OrderMaster orderMaster = new OrderMaster();
        //判断订单状态
        if (!orderDto.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.info("【完结订单】 订单状态不正确，orderId={},orderStatus = {}", orderDto.getOrderId(), orderDto.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDto.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        BeanUtils.copyProperties(orderDto, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult == null) {
            log.info("【完结订单】 更新失败 orderMaster= {}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FALL);
        }

        return orderDto;
    }

    @Override
    @Transactional
    public OrderDto paid(OrderDto orderDto) {
        //判断订单状态
        if (!orderDto.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.info("【支付订单】 订单状态不正确，orderId={},orderStatus = {}", orderDto.getOrderId(), orderDto.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //判断支付状态
        if (!orderDto.getPayStatus().equals(PayStatusEnum.WAIT.getCode())) {
            log.info("【支付订单】 支付状态不正确，orderId={},payStatus = {}", orderDto.getOrderId(), orderDto.getPayStatus());
            throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }

        //修改支付状态
        orderDto.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto, orderMaster);
        OrderMaster updateOrderMaster = orderMasterRepository.save(orderMaster);
        if (updateOrderMaster == null) {
            log.info("【支付订单】 更新失败 orderMaster= {}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FALL);
        }

        return orderDto;
    }

    @Override
    public Page<OrderDto> findList(Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findAll(pageable);
        List<OrderDto> orderDtoList = OrderMasterToOrderDtoConverter.convert(orderMasterPage.getContent());


        Page<OrderDto> orderDtoPage = new PageImpl<>(orderDtoList, pageable, orderMasterPage.getTotalElements());
        return orderDtoPage;
    }
}
