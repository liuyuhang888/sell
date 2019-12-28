package com.liuyuhang.sell.service;

import com.liuyuhang.sell.dto.OrderDto;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/24 14:31
 * @Description:
 */
public interface BuyerService {
    //查询一个订单
    OrderDto findOrderOne(String openid, String orderId);

    //取消订单
    OrderDto cancelOrder(String openid, String orderId);
}
