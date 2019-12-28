package com.liuyuhang.sell;/**
 * @Auther: 刘宇航
 * @Date: 2019/11/16 23:38
 * @Description:
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: liuyuhang
 * @time: 2019/11/16 23:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Slf4j 写了之后可直接调用log
//@Data
public class LoggerTest {
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    //注意，写当前类

    @Test
    public void test1() {
        String name = "root";
        String password = "123456";
        logger.debug("debug");
        logger.info("info");
        logger.info("name: {},password：{}", name, password); //{}为占位符
        logger.warn("debug");

    }
}
