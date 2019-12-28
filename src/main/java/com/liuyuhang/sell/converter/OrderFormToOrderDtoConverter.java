package com.liuyuhang.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liuyuhang.sell.dataobject.OrderDetail;
import com.liuyuhang.sell.dto.OrderDto;
import com.liuyuhang.sell.enums.ResultEnum;
import com.liuyuhang.sell.exception.SellException;
import com.liuyuhang.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/21 08:52
 * @Description:
 */
@Slf4j
public class OrderFormToOrderDtoConverter {
    public static OrderDto convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList;
        try {
            orderDetailList = (List<OrderDetail>) gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误,String = {}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }
}
