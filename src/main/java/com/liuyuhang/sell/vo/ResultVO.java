package com.liuyuhang.sell.vo;

import lombok.Data;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 15:48
 * @Description: http请求返回的最外层对象
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg = "";
    /**
     * 返回的具体内容
     */
    private T data;
}
