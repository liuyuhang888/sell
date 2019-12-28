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
                                商品id
                            </th>
                            <th>
                                名称
                            </th>
                            <th>
                                图片
                            </th>
                            <th>
                                单价
                            </th>
                            <th>
                                库存
                            </th>
                            <th>
                                描述
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
                        <#list productInfoPage.getContent() as productInfo>
                            <tr class="info">
                                <td>
                                    ${productInfo.getProductId()}
                                </td>
                                <td>
                                    <img style="height: 70px" width="70px" src="${productInfo.getProductIcon()}">
                                </td>
                                <td>
                                    ${productInfo.getProductPrice()}
                                </td>
                                <td>
                                    ${productInfo.getProductStock()}
                                </td>
                                <td>
                                    ${productInfo.getProductDescription()}
                                </td>
                                <td>
                                    ${productInfo.getCategoryType()}
                                </td>
                                <td>
                                    ${productInfo.getCreateTime()}
                                </td>
                                <td>
                                    ${productInfo.getUpdateTime()}
                                </td>
                                <td>
                                    <a href="/sell/seller/product/index?productId=${productInfo.getProductId()}"
                                       type="button"
                                       class="btn btn-default  btn-info">修改</a>
                                </td>
                                <td>
                                    <#if productInfo.getProductStatusEnum().getMessage() == "上架">
                                        <a type="button"
                                           href="/sell/seller/product/offSale?productId=${productInfo.getProductId()}"
                                           class="btn btn-default  btn-danger"> 下架
                                        </a>
                                    <#else >
                                        <a type="button"
                                           href="/sell/seller/product/onSale?productId=${productInfo.getProductId()}"
                                           class="btn btn-default  btn-success"> 上架
                                        </a>
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
                                <a href="/sell/seller/product/list?page=${currentPage-1}&size=${productInfoPage.getSize()}">上一页</a>
                            </li>
                        <#else >
                            <li class="disabled">
                                <a href="#">上一页</a>
                            </li>
                        </#if>

                        <#if productInfoPage.getTotalPages() gte 11>
                            <#if currentPage gte 6>
                                <#list currentPage-5..showEndPage as i>
                                    <#if currentPage == i>
                                        <li class="disabled"><a href="#"> ${i}</a></li>
                                    <#else>
                                        <li>
                                            <a href="/sell/seller/product/list?page=${i}&size=${productInfoPage.getSize()}"> ${i}</a>
                                        </li>
                                    </#if>
                                </#list>
                            <#else >
                                <#list 1..11 as i >
                                    <#if currentPage == i>
                                        <li class="disabled"><a href="#"> ${i}</a></li>
                                    <#else>
                                        <li>
                                            <a href="/sell/seller/product/list?page=${i}&size=${productInfoPage.getSize()}"> ${i}</a>
                                        </li>
                                    </#if>
                                </#list>
                            </#if>
                        <#else >
                            <#list 1..productInfoPage.getTotalPages() as i >
                                <#if currentPage == i>
                                    <li class="disabled"><a href="#"> ${i}</a></li>
                                <#else>
                                    <li>
                                        <a href="/sell/seller/product/list?page=${i}&size=${productInfoPage.getSize()}"> ${i}</a>
                                    </li>
                                </#if>

                            </#list>
                        </#if>

                        <#if currentPage gte productInfoPage.getTotalPages()>
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        <#else >
                            <li>
                                <a href="/sell/seller/product/list?page=${currentPage+1}&size=${productInfoPage.getSize()}">下一页</a>
                            </li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<#include "../common/footer.ftl" >
</html>

