package com.liuyuhang.sell.service.impl;

import com.liuyuhang.sell.dto.OrderDto;
import com.liuyuhang.sell.enums.ResultEnum;
import com.liuyuhang.sell.exception.SellException;
import com.liuyuhang.sell.service.BuyerService;
import com.liuyuhang.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/24 14:33
 * @Description:
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDto findOrderOne(String openid, String orderId) {
        OrderDto orderDto = checkOrderOwner(openid, orderId);
        return orderDto;
    }

    @Override
    public OrderDto cancelOrder(String openid, String orderId) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【取消订单】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        if (StringUtils.isEmpty(orderId)) {
            log.error("【取消订单】 orderid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDto orderDto = checkOrderOwner(openid, orderId);
        if (orderDto == null) {
            log.error("【取消订单】 查不到该订单，orderid = {}", orderId);
        }
        return orderService.cancel(orderDto);
    }

    private OrderDto checkOrderOwner(String openid, String orderId) {

        OrderDto orderDto = orderService.findOne(orderId);
        if (!orderDto.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】 订单的openId不一致 openid = {},orderDto = {}", openid, orderDto);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDto;
    }

}
