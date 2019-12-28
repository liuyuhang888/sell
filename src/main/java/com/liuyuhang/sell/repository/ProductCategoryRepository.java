package com.liuyuhang.sell.repository;/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 00:56
 * @Description:
 */

import com.liuyuhang.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description:
 * @author: liuyuhang
 * @time: 2019/11/17 0:56
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
