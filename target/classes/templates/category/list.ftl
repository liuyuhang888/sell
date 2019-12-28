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

                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>
                                类目id
                            </th>
                            <th>
                                类目名称
                            </th>
                            <th>
                                类目编号
                            </th>
                            <th>
                                创建时间
                            </th>
                            <th>
                                修改时间
                            </th>
                            <th colspan="2">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list productCategoryList as productCategory>
                            <tr class="info">
                                <td>
                                    ${productCategory.categoryId}
                                </td>
                                <td>
                                    ${productCategory.categoryName}
                                </td>
                                <td>
                                    ${productCategory.categoryType}
                                </td>
                                <td>
                                    ${productCategory.createTime}
                                </td>
                                <td>
                                    ${productCategory.updateTime}
                                </td>
                                <td>
                                    <a href="/sell/seller/category/index?categoryId=${productCategory.categoryId}"
                                       type="button"
                                       class="btn btn-default  layui-btn-info">编辑</a>
                                </td>
                                <td>
                                    <a type="button" onclick="deleteCategory(${productCategory.categoryId})"
                                       class="btn btn-default  layui-btn-danger">删除</a>
                                </td>

                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<#include "../common/footer.ftl" >
<script>
    function deleteCategory(categoryId) {
        if (confirm("警告:\u000d                       删除分类同时会删除分类下的所有商品.")) {
            location.href = "/sell/seller/category/delete?categoryId=" + categoryId;
        }
    }
</script>
</html>