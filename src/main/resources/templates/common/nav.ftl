<#include "../common/header.ftl">
<div class="layui-header">
    <div class="layui-logo">微信售卖后台管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="">控制台</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                <span id="username"></span>
            </a>
            <dl class="layui-nav-child">
            </dl>
        </li>
        <li class="layui-nav-item"><a href="/sell/seller/user/logout">退出登录</a></li>
    </ul>
</div>
<script>
    window.onload = function () {

        var username = document.getElementById("username");
        username.innerHTML = getCookie("token_username");

        function getCookie(name) {
            var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

            if (arr = document.cookie.match(reg))

                return unescape(arr[2]);
            else
                return null;
        }
    }

</script>