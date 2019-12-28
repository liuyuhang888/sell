<!doctype html>
<html>
<body>
<div class="layui-layout layui-layout-admin">
    <#include "../common/nav.ftl">
    <#include "../common/left.ftl">
    <div class="layui-body">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form class="layui-form" action="/sell/seller/product/save" method="post">
                        <div class="layui-form-item">
                            <label class="layui-form-label">名称</label>
                            <div class="layui-input-block">
                                <input type="text" name="productName" required lay-verify="required"
                                       placeholder="请输入商品名称"
                                       autocomplete="off" class="layui-input"
                                       value="${(productInfo.getProductName())!''}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">价格</label>
                            <div class="layui-input-block">
                                <input type="text" name="productPrice" required lay-verify="required"
                                       placeholder="请输入商品价格"
                                       autocomplete="off" class="layui-input"
                                       value="${(productInfo.getProductPrice())!''}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">库存</label>
                            <div class="layui-input-block">
                                <input type="text" name="productStock" required lay-verify="required"
                                       placeholder="请输人商品库存"
                                       autocomplete="off" class="layui-input"
                                       value="${(productInfo.getProductStock())!''}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">描述</label>
                            <div class="layui-input-block">
                                <input type="text" name="productDescription" required lay-verify="required"
                                       placeholder="请输入商品描述"
                                       autocomplete="off" class="layui-input"
                                       value="${(productInfo.getProductDescription())!''}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">图片</label>
                            <img src="${(productInfo.getProductIcon())!''}" width="200px" height="200px">
                            <#--                            <button type="button" class="layui-btn" id="test1">-->
                            <#--                                <i class="layui-icon">&#xe67c;</i>上传图片-->
                            <#--                            </button>-->
                            <input type="text" name="productIcon" class="layui-input" autocomplete="off" required
                                   lay-verify="required" placeholder="请输入图片路径" value="${(productInfo.productIcon)!''}">
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">产品类别</label>
                            <div class="layui-input-block">
                                <select name="categoryType" lay-verify="required">
                                    <#list catagoryList as category>
                                        <option value="${(category.getCategoryType())!''}"
                                                <#if (productInfo.getCategoryType())?? && category.getCategoryType()== productInfo.getCategoryType() > selected="selected"
                                                </#if> > ${(category.getCategoryName())!'' }</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <#--                        隐藏提交id属性-->
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script src="https://cdn.bootcss.com/jquery/3.4.1/core.js"></script>
<script src="/sell/layui/layui.all.js"/>
<script>
    layui.use('element', function () {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        element.init();
    });

    layui.use('form', function () {
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
    layui.use('upload', function () {
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            , url: 'sell/seller/product/upload/' //上传接口
            , done: function (res) {
                //上传完毕回调
            }
            , error: function () {
                //请求异常回调
            }
        });
    });
</script>