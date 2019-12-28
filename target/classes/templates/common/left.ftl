<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">订单管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="/sell/seller/order/list">订单列表</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">商品管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="/sell/seller/product/list">商品列表</a></dd>
                    <dd><a href="/sell/seller/product/index">添加商品</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">类目管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="/sell/seller/category/list">类目列表</a></dd>
                    <dd><a href="/sell/seller/category/index">新增类目</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">日志监控</a>
                <dl class="layui-nav-child">
                    <dd><a href="/sell/druid/index">druid数据源监控</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>