package com.liuyuhang.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: 刘宇航
 * @Date: 2019/12/3 16:21
 * @Description:
 */
@Data
public class ProductForm {

    private String productId;
    /**
     * 商品名字
     */
    private String productName;
    /**
     * 单价
     */
    private BigDecimal productPrice;
    /**
     * 库存
     */
    private Integer productStock;
    /**
     * 描述
     */
    private String productDescription;
    /**
     * 小图
     */
    private String productIcon;
    /**
     * 类目编号
     */
    private Integer categoryType;

}
