package com.liuyuhang.sell.service.impl;

import com.liuyuhang.sell.dataobject.OrderDetail;
import com.liuyuhang.sell.dto.OrderDto;
import com.liuyuhang.sell.enums.OrderStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/19 23:58
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private final String ORDER_ID = "1574181668490597704";
    private final String PRODUCT_ID = "123456";
    private final String OPENID = "ew3euwhd7sjw9diwkq";

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerAddress("慕网");
        orderDto.setBuyerName("刘宇航");
        orderDto.setBuyerPhone("1234566890");
        orderDto.setBuyerOpenid(OPENID);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId(PRODUCT_ID);
        o1.setProductQuantity(3);
        orderDetailList.add(o1);

        orderDto.setOrderDetailList(orderDetailList);
        OrderDto result = orderService.create(orderDto);
        log.info("【创建订单】 result = {}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDto result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】 result = {}", result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void cancel() {
        OrderDto orderDto = orderService.findOne("1574263726016875684");
        OrderDto result = orderService.cancel(orderDto);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDto orderDto = orderService.findOne("1574263726016875684");
        OrderDto result = orderService.finish(orderDto);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void list() {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDto> orderDtoPage = orderService.findList(request);
        Assert.assertNotEquals(0, orderDtoPage.getTotalElements());
        //Assert.assertTrue("", orderDtoPage.getTotalElements() > 0);
    }
}