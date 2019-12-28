package com.liuyuhang.sell.service;

import com.liuyuhang.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 01:51
 * @Description:
 */

public interface CategoryService {
    ProductCategory findone(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

    void delete(Integer categoryId);
}
