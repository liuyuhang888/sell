package com.liuyuhang.sell.exception;

import com.liuyuhang.sell.enums.ResultEnum;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 14:51
 * @Description:
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();

    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
