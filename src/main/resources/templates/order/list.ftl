<!doctype html>
<html lang="en">
<body>
<div class="layui-layout layui-layout-admin">
    <#include "../common/nav.ftl">
    <#include "../common/left.ftl">
    <div class="layui-body">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>
                                订单编号
                            </th>
                            <th>
                                买家姓名
                            </th>
                            <th>
                                手机号
                            </th>
                            <th>
                                地址
                            </th>
                            <th>
                                金额
                            </th>
                            <th>
                                订单状态
                            </th>
                            <th>
                                支付方式
                            </th>
                            <th>
                                支付状态
                            </th>
                            <th>
                                创建时间
                            </th>
                            <th colspan="2">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderDtoPage.getContent() as orderDto>
                            <tr class="info">
                                <td>
                                    ${orderDto.getOrderId()}
                                </td>
                                <td>
                                    ${orderDto.getBuyerName()}
                                </td>
                                <td>
                                    ${orderDto.getBuyerPhone()}
                                </td>
                                <td>
                                    ${orderDto.getBuyerAddress()}
                                </td>
                                <td>
                                    ${orderDto.getOrderAmount()}
                                </td>
                                <td>
                                    ${orderDto.getOrderStatusEnum().msg}
                                </td>
                                <td>
                                    微信
                                </td>
                                <td>
                                    ${orderDto.getPayStatusEnum().msg}
                                </td>
                                <td>
                                    ${orderDto.getCreateTime()}
                                </td>
                                <td>
                                    <a href="/sell/seller/order/detail?orderId=${orderDto.getOrderId()}" type="button"
                                       class="btn btn-default  btn-info">详情</a>
                                </td>
                                <td>
                                    <#if orderDto.getOrderStatusEnum().getMsg()=="新订单">
                                        <button type="button" class="btn btn-default  btn-danger"
                                                onclick="cancel(${orderDto.getOrderId()})">取消
                                        </button>
                                    </#if>

                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <#if !(currentPage lte 1) >
                            <li>
                                <a href="/sell/seller/order/list?page=${currentPage-1}&size=${orderDtoPage.getSize()}">上一页</a>
                            </li>
                        <#else >
                            <li class="disabled">
                                <a href="#">上一页</a>
                            </li>
                        </#if>

                        <#if orderDtoPage.getTotalPages() gte 11>
                            <#if currentPage gte 6>
                                <#list currentPage-5..showEndPage as i>
                                    <#if currentPage == i>
                                        <li class="disabled"><a href="#"> ${i}</a></li>
                                    <#else>
                                        <li>
                                            <a href="/sell/seller/order/list?page=${i}&size=${orderDtoPage.getSize()}"> ${i}</a>
                                        </li>
                                    </#if>
                                </#list>
                            <#else >
                                <#list 1..11 as i >
                                    <#if currentPage == i>
                                        <li class="disabled"><a href="#"> ${i}</a></li>
                                    <#else>
                                        <li>
                                            <a href="/sell/seller/order/list?page=${i}&size=${orderDtoPage.getSize()}"> ${i}</a>
                                        </li>
                                    </#if>
                                </#list>
                            </#if>
                        <#else >
                            <#list 1..orderDtoPage.getTotalPages() as i >
                                <#if currentPage == i>
                                    <li class="disabled"><a href="#"> ${i}</a></li>
                                <#else>
                                    <li>
                                        <a href="/sell/seller/order/list?page=${i}&size=${orderDtoPage.getSize()}"> ${i}</a>
                                    </li>
                                </#if>

                            </#list>
                        </#if>

                        <#if currentPage gte orderDtoPage.getTotalPages()>
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        <#else >
                            <li>
                                <a href="/sell/seller/order/list?page=${currentPage+1}&size=${orderDtoPage.getSize()}">下一页</a>
                            </li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">
                        您有新的订单
                    </h4>
                </div>
                <div class="modal-body">

                </div>
                <div class="modal-footer">
                    <button onclick="window.location.reload()" type="button" class="btn btn-primary">查看订单</button>
                </div>
            </div>
        </div>
    </div>
</div>
<video id="vdo"></video>
<iframe allow="autoplay" style="display:none" src="一个空的音频文件" id="ifm"></iframe>
</body>
<#include "../common/footer.ftl" >
<script>
    var websocket = null;
    if ("websocket" in window) {
        websocket = new WebSocket('ws://localhost:8080/sell/webSocket');
    } else {
        alert("该浏览器不支持");
    }
    websocket.onopen = function (event) {
        console.log("建立连接");
    }
    websocket.onclose = function (even) {
        console.log("连接关闭");
    }
    websocket.onmessage = function (event) {
        console.log("收到消息" + event.data)
        $("#myModal").modal('show');
        document.querySelector(".modal-body").innerHTML = "您有新的订单,请您接单,订单编号为:" + event.data;
        //播放音乐
        document.querySelector("#ifm").onload = function () {
            var vdo = document.getElementById("vdo");
            vdo.src = 'http://sell.com/sell/mp3/newOrder.mp3';
            vdo.oncanplay = function () {
                vdo.play();
            };
        }

    }
    websocket.onerror = function (event) {
        alert("webSocket通信发生错误");
    }

    window.onbeforeunload = function () {
        websocket.close();
    }

    function stop() {
        document.getElementById('notice').pause();
        location.reload();
    }

</script>
</html>

