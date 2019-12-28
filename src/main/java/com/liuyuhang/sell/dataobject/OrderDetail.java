package com.liuyuhang.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 01:31
 * @Description:
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;
    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 单价
     */
    private BigDecimal productPrice;
    /**
     * 商品数量
     */
    private Integer productQuantity;
    /**
     * 商品小图
     */
    private String ProductIcon;
}
