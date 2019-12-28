package com.liuyuhang.sell.enums;

import lombok.Getter;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 14:34
 * @Description: 商品状态
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    UP(0, "上架"), DOWN(1, "下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
