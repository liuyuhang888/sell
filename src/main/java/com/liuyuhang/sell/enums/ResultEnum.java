package com.liuyuhang.sell.enums;

import lombok.Getter;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 14:52
 * @Description:
 */
@Getter
public enum ResultEnum {
    SUCCESS(0, "成功"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不正确"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FALL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17, "支付状态不正确"),
    PARAM_ERROR(18, "参数不正确"),
    CHAR_EMPTY(19, "购物车为空"),
    ORDER_OWNER_ERROR(20, "该订单不属于当前用户"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21, ""),
    ORDER_CANCEL_SUCCESS(22, "订单取消成功"),
    ORDER_FINISH_SUCCESS(23, "订单完结成功"),
    PRODUCT_STATUS_ERROR(23, "产品状态不正确"),
    CATEGORY_NOT_EXIST(24, "分类不存在"),
    CATEGORY_TYPE_EXIST(25, "当前分类编号已存在"),
    LOGOUT_SUCCESS(26, "退出登录成功");
    //OPENID_EMPTY(20,"openid为空");
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
