package com.liuyuhang.sell.converter;

import com.liuyuhang.sell.dataobject.OrderMaster;
import com.liuyuhang.sell.dto.OrderDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/20 01:32
 * @Description:
 */
public class OrderMasterToOrderDtoConverter {
    public static OrderDto convert(OrderMaster orderMaster) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderMaster, orderDto);

        return orderDto;

    }

    public static List<OrderDto> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e -> convert(e)
        ).collect(Collectors.toList());
    }
}
