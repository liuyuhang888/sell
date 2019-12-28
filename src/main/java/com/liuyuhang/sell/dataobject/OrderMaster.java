package com.liuyuhang.sell.dataobject;

import com.liuyuhang.sell.enums.OrderStatusEnum;
import com.liuyuhang.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 00:57
 * @Description:
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    /**
     * 订单id
     */
    @Id
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
    private Integer OrderStatus = OrderStatusEnum.NEW.getCode();
    /**
     * 支付状态，默认为0未支付
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    // @Transient  在数据库映射时忽略此字段
    // private List<OrderDetail> orderDetailList;   这种方式使entity类混乱

}
