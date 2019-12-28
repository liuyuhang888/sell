package com.liuyuhang.sell.utils;

import com.liuyuhang.sell.enums.CodeEnum;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/26 11:10
 * @Description:
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getBycCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
