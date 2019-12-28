package com.liuyuhang.sell.repository;

import com.liuyuhang.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 00:58
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findoneText() {
        ProductCategory one = productCategoryRepository.findOne(1);
        System.out.println(one);
    }

    @Test
    public void saveText() {
        ProductCategory ProductCategory = new ProductCategory();
        ProductCategory.setCategoryName("女生最爱");
        ProductCategory.setCategoryType(3);
        productCategoryRepository.save(ProductCategory);
    }

    @Test
    @Transactional //测试数据不会跑到数据库中（完全回滚）
    public void updataText() {
        ProductCategory one = productCategoryRepository.findOne(2);
        one.setCategoryType(10);
        Assert.assertNotNull(productCategoryRepository.save(one));
    }

    @Test
    @Transactional
    public void findByCategoryTypeInText() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}