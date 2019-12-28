package com.liuyuhang.sell.controller;

import com.liuyuhang.sell.dataobject.ProductCategory;
import com.liuyuhang.sell.dataobject.ProductInfo;
import com.liuyuhang.sell.service.CategoryService;
import com.liuyuhang.sell.service.ProductService;
import com.liuyuhang.sell.utils.ResultVOUtil;
import com.liuyuhang.sell.vo.ProductInfoVO;
import com.liuyuhang.sell.vo.ProductVO;
import com.liuyuhang.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 15:42
 * @Description: 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO List() {

        //1.查询所有上架的商品
        List<ProductInfo> upAll = productService.findUpAll();
        //2.查询类目（一次性查询）
        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
        for (ProductInfo productInfo : upAll) {
            categoryTypeList.add(productInfo.getCategoryType());
        }

        //精简方法（java8 ,lambda表达式）
        // List<Integer> list = upAll.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //2.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : upAll) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                    productInfoVO.setProductDescription(productInfo.getProductDescription());
//                    productInfoVO.setProductIcon(productInfo.getProductIcon());
//                    productInfoVO.setProductId(productInfo.getProductId());
//                    productInfoVO.setProductName(productInfo.getProductName());
//                    productInfoVO.setProductPrice(productInfo.getProductPrice());
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }

            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
