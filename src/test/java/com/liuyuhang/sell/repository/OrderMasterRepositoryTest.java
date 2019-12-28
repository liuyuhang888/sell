package com.liuyuhang.sell.repository;

import com.liuyuhang.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 01:52
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "11011";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123256");
        orderMaster.setBuyerName("李四");
        orderMaster.setBuyerPhone("123456389123");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.3));
        OrderMaster result = repository.save(orderMaster);

        Assert.assertNotNull(result);
    }


    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0, 1);
        //PageRequest 继承于抽象的PageRequest 实现了PageAble;
        Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0, byBuyerOpenid.getTotalElements());

    }
}