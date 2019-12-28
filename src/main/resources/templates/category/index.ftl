<!doctype html>
<html>
<body>
<div class="layui-layout layui-layout-admin">
    <#include "../common/nav.ftl">
    <#include "../common/left.ftl">
    <div class="layui-body">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column" style="padding-top: 50px;">
                    <form class="form-horizontal" role="form" action="/sell/seller/category/save" method="post">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">类别名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="layui-form-text" name="categoryName"
                                       value="${(categoryInfo.categoryName)!""}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">类别id</label>
                            <div class="col-sm-10">

                                <input type="text" class="layui-form-text" name="categoryType"
                                       value="${(categoryInfo.categoryType)!''}"/>
                            </div>
                            <input hidden type="text" value=" ${(categoryInfo.categoryId)!""}" name="categoryId">
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">

                                <button type="submit" class="btn btn-success">
                                    <#if categoryInfo??>
                                        修改
                                    <#else >
                                        添加
                                    </#if>
                                </button>
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
<#include "../common/footer.ftl" >