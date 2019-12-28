package com.liuyuhang.sell.service;

import com.liuyuhang.sell.dataobject.SellerInfo;

/**
 * @Auther: 刘宇航
 * @Date: 2019/12/9 21:31
 * @Description:
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenId(String openId);

    SellerInfo login(SellerInfo sellerInfo);
}
