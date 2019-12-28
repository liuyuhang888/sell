package com.liuyuhang.sell.repository;/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 13:43
 * @Description:
 */

import com.liuyuhang.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description:
 * @author: liuyuhang
 * @time: 2019/11/17 13:43
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);

    // @Modifying
    // @Query("delete from User u where user.role.id = ?1")
    void deleteByCategoryType(Integer categoryType);

    List<ProductInfo> findByCategoryType(Integer categoryType);

}
