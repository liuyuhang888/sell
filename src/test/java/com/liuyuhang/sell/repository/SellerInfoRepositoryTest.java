package com.liuyuhang.sell.repository;

import com.liuyuhang.sell.dataobject.SellerInfo;
import com.liuyuhang.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: 刘宇航
 * @Date: 2019/12/9 21:00
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");
        SellerInfo save = repository.save(sellerInfo);
        Assert.assertNotNull(save);

    }

    @Test
    public void findByOpenid() {
        SellerInfo abc = repository.findByOpenid("abc");
        Assert.assertEquals("abc", abc.getOpenid());
    }
}