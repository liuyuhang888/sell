package com.liuyuhang.sell.service.impl;/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 01:56
 * @Description:
 */

import com.liuyuhang.sell.dataobject.ProductCategory;
import com.liuyuhang.sell.dataobject.ProductInfo;
import com.liuyuhang.sell.enums.ResultEnum;
import com.liuyuhang.sell.exception.SellException;
import com.liuyuhang.sell.repository.ProductCategoryRepository;
import com.liuyuhang.sell.service.CategoryService;
import com.liuyuhang.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: liuyuhang
 * @time: 2019/11/17 1:56
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;
    @Autowired
    private ProductService productService;

    @Override
    public ProductCategory findone(Integer categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        List<ProductCategory> categoryList = categoryRepository.findAll();

        for (ProductCategory category : categoryList) {
            if (category.getCategoryType() == productCategory.getCategoryType()
                    && category.getCategoryId() != productCategory.getCategoryId()) {
                throw new SellException(ResultEnum.CATEGORY_TYPE_EXIST);
            }
        }
        //判断是否是修改
        if (productCategory.getCategoryId() != null) {
            //查询修改之前的产品类别
            ProductCategory beforeCategory = findone(productCategory.getCategoryId());
            //修改所有对应商品的类别
            List<ProductInfo> byCategoryType = productService.findByCategoryType(beforeCategory.getCategoryType());
            if (byCategoryType != null) {
                for (ProductInfo productInfo : byCategoryType) {
                    productInfo.setCategoryType(productCategory.getCategoryType());
                    productInfo.setUpdateTime(new Date());
                }
            }
        }

        return categoryRepository.save(productCategory);
    }

    @Override
    @Transactional
    public void delete(Integer categoryId) {
        ProductCategory category = categoryRepository.findOne(categoryId);
        if (category == null) {
            log.info("[删除分类] categoryId = {}", categoryId);
            new SellException(ResultEnum.CATEGORY_NOT_EXIST);
        }
        //删除分类对应商品
        productService.delete(category.getCategoryType());
        //删除分类
        categoryRepository.delete(categoryId);


    }
}
