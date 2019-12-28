package com.liuyuhang.sell.service;

import com.liuyuhang.sell.dto.OrderDto;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;


public interface PayService {

    PayResponse create(OrderDto orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDto orderDTO);
}
