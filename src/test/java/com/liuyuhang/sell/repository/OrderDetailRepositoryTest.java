package com.liuyuhang.sell.repository;

import com.liuyuhang.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 14:06
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void textSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123746");
        orderDetail.setOrderId("123476");
        orderDetail.setProductId("125456");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(10.2));
        orderDetail.setProductQuantity(2);

        OrderDetail result = repository.save(orderDetail);

        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> result = repository.findByOrderId("123456");
        Assert.assertNotEquals(0, result.size());
    }

}