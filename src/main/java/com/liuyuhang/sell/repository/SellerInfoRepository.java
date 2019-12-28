package com.liuyuhang.sell.repository;

import com.liuyuhang.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: 刘宇航
 * @Date: 2019/12/9 20:58
 * @Description:
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);

    SellerInfo findByUsername(String username);
}
