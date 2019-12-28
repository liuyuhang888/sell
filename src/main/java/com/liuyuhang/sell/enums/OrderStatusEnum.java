package com.liuyuhang.sell.enums;

import lombok.Getter;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 01:20
 * @Description:
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "新订单"), FINISHED(1, "完结"), CANCEL(2, "已取消");
    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    /* 可向上抽取成接口
     public static OrderStatusEnum getOrderStatusEnum(Integer code){
        for(OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()){
            if (orderStatusEnum.getCode().equals(code)){
                return orderStatusEnum;
            }
        }
        return null;
    }*/
}
