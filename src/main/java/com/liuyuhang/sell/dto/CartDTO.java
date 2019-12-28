package com.liuyuhang.sell.dto;

import lombok.Data;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/19 23:26
 * @Description:
 */
@Data
public class CartDTO {
    /**
     * 商品Id
     */
    private String productId;
    /**
     * 数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
