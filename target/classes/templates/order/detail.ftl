<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <#include "../common/nav.ftl">
    <#include "../common/left.ftl">
    <div class="layui-body">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                        <tr>
                            <th>
                                订单id
                            </th>
                            <th>
                                订单总金额
                            </th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr class="info">
                            <td>
                                ${orderDto.getOrderId()}
                            </td>
                            <td>
                                ${orderDto.getOrderAmount()}
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>
                                    商品id
                                </th>
                                <th>
                                    商品名称
                                </th>
                                <th>
                                    价格
                                </th>
                                <th>
                                    数量
                                </th>
                                <th>
                                    总额
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDto.getOrderDetailList() as orderDetil>
                                <tr class="info">
                                    <td>
                                        ${orderDetil.getProductId()}
                                    </td>
                                    <td>
                                        ${orderDetil.getProductName()}
                                    </td>
                                    <td>
                                        ${orderDetil.getProductPrice()}
                                    </td>
                                    <td>
                                        ${orderDetil.getProductQuantity()}
                                    </td>
                                    <td>
                                        ${orderDetil.getProductPrice()*orderDetil.getProductQuantity()}
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
                <#if orderDto.getOrderStatusEnum().getMsg()=="新订单">
                    <a href="/sell/seller/order/finish?orderId=${orderDto.getOrderId()}"
                       class="btn btn-primary">完结订单</a>
                    <a href="/sell/seller/order/cancel?orderId=${orderDto.getOrderId()}" class="btn btn-danger">取消订单</a>
                </#if>
            </div>
        </div>
    </div>
</div>
</body>
</html>