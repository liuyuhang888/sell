package com.liuyuhang.sell.dataobject;/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 13:36
 * @Description:
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liuyuhang.sell.enums.ProductStatusEnum;
import com.liuyuhang.sell.utils.EnumUtil;
import com.liuyuhang.sell.utils.KeyUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: liuyuhang
 * @time: 2019/11/17 13:36
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
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
     * 状态 0正常  1下架
     */
    private Integer productStatus;
    /**
     * 类目编号
     */
    private Integer categoryType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


//    @Transient
//    public String getProductCategoryStr() {
//
//        return KeyUtil.getCategoryTypeStr(this.categoryType,new CategoryServiceImpl());
//    }

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getBycCode(this.getProductStatus(), ProductStatusEnum.class);
    }

    public String getProductId() {
        if (StringUtils.isEmpty(this.productId)) {
            this.setProductId(KeyUtil.genUniqueKey());
        }
        return this.productId;
    }
}
