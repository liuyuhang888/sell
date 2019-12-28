package com.liuyuhang.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.liuyuhang.sell.dataobject.OrderDetail;
import com.liuyuhang.sell.enums.OrderStatusEnum;
import com.liuyuhang.sell.enums.PayStatusEnum;
import com.liuyuhang.sell.utils.EnumUtil;
import com.liuyuhang.sell.utils.serializer.DateToLongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 14:32
 * @Description:
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 买家名字
     */
    private String buyerName;
    /**
     * 买家手机号
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家微信openid
     */
    private String buyerOpenid;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态  默认为0新下单
     */
    private Integer OrderStatus;
    /**
     * 支付状态，默认为0未支付
     */
    private Integer payStatus;
    /**
     * 创建时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date updateTime;
    /**
     * 订单详情列表
     */
    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getBycCode(this.getOrderStatus(), OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getBycCode(this.getPayStatus(), PayStatusEnum.class);
    }

}
