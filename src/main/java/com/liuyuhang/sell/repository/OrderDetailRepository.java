package com.liuyuhang.sell.repository;

import com.liuyuhang.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 01:45
 * @Description:
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}
