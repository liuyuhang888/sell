package com.liuyuhang.sell.service.impl;

import com.liuyuhang.sell.dataobject.SellerInfo;
import com.liuyuhang.sell.exception.SellAuthorizeException;
import com.liuyuhang.sell.repository.SellerInfoRepository;
import com.liuyuhang.sell.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 刘宇航
 * @Date: 2019/12/9 21:32
 * @Description:
 */
@Service
@Slf4j
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openId) {

        return repository.findByOpenid(openId);
    }

    @Override
    public SellerInfo login(SellerInfo sellerInfo) {
        SellerInfo byUsername = repository.findByUsername(sellerInfo.getUsername());
        if (byUsername == null) {
            log.info("不存在此用户 username = {}", sellerInfo.getUsername());
            throw new SellAuthorizeException();
        }
        if (!byUsername.getPassword().equals(sellerInfo.getPassword())) {
            log.info("密码错误 username = {}", sellerInfo.getUsername());
            throw new SellAuthorizeException();
        }
        return sellerInfo;
    }


}
