package com.liuyuhang.sell.service;/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 13:58
 * @Description:
 */

import com.liuyuhang.sell.dataobject.ProductInfo;
import com.liuyuhang.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @description:
 * @author: liuyuhang
 * @time: 2019/11/17 13:58
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /*
     *
     * 功能描述:  查询所有在架的商品列表
     *
     * @param:
     * @return: java.util.List<com.liuyuhang.sell.dataobject.ProductInfo>
     * @auther: liuyuhang
     * @date: 2019/11/17 14:00
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);

    //根据类型删除商品
    void delete(Integer productType);

    List<ProductInfo> findByCategoryType(Integer categoryType);

}
