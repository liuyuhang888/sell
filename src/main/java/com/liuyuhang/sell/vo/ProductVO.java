package com.liuyuhang.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 22:15
 * @Description: 产品视图(包含类目)
 */
@Data
public class ProductVO {
    //注解的作用是在把对象序列化给前端时，名称是name

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
