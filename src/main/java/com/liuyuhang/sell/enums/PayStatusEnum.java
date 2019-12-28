package com.liuyuhang.sell.enums;

import lombok.Getter;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 01:26
 * @Description:
 */
@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0, "等待支付"), SUCCESS(1, "支付成功");
    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    /*public static PayStatusEnum getPayStatusEnum(Integer code){
        for(PayStatusEnum payStatusEnum : PayStatusEnum.values()){
            if (payStatusEnum.getCode().equals(code)){
                return payStatusEnum;
            }
        }
        return null;
    }*/
}
