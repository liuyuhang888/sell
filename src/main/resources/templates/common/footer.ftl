<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="/sell/layui/layui.all.js"/>
<script>
    function cancel(orderid) {
        location.href = "http://sell.com/sell/seller/order/cancel?orderId=" + orderid;
    }

    layui.use('element', function () {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        element.init();
    });
</script>