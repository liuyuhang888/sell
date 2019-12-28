package com.liuyuhang.sell.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 15:14
 * @Description:
 */
@Component
public class KeyUtil {
    /**
     * 功能描述: 生成唯一主键
     * 格式： 时间+随机数
     *
     * @param:
     * @return: java.lang.String
     * @auther: liuyuhang
     * @date: 2019/11/18 15:15
     */

    public static synchronized String genUniqueKey() {
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
//    public  static String getCategoryTypeStr(Integer categoryType,CategoryService categoryService){
//        return categoryService.findone(categoryType).getCategoryName();
//    }
}
