package com.liuyuhang.sell.controller;

import com.liuyuhang.sell.dataobject.ProductCategory;
import com.liuyuhang.sell.enums.ResultEnum;
import com.liuyuhang.sell.exception.SellException;
import com.liuyuhang.sell.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 刘宇航
 * @Date: 2019/12/6 14:00
 * @Description:
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> productCategoryList = null;
        try {
            productCategoryList = categoryService.findAll();

        } catch (SellException e) {
            e.printStackTrace();
            map.put("url", "sell/seller/category/list");
            return new ModelAndView("common/error", map);
        }
        map.put("productCategoryList", productCategoryList);
        map.put("url", "sell/seller/category/list");
        return new ModelAndView("category/list", map);

    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("categoryId") Integer categoryId, Map<String, Object> map) {
        try {
            categoryService.delete(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/category/list");
        map.put("msg", "删除分类成功");

        return new ModelAndView("common/success", map);

    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId, Map<String, Object> map) {
        if (StringUtils.isEmpty(categoryId)) {
            return new ModelAndView("category/index");
        }
        ProductCategory categoryInfo = categoryService.findone(categoryId);
        map.put("categoryInfo", categoryInfo);
        return new ModelAndView("category/index", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestParam(value = "categoryId", required = false) Integer categoryId, ProductCategory category, Map<String, Object> map) {
        try {
            if (categoryId != null) {
                ProductCategory productCategory = categoryService.findone(categoryId);
                if (productCategory == null) {
                    new SellException(ResultEnum.CATEGORY_NOT_EXIST);
                }

                categoryService.save(category);
            }
            if (categoryId == null) {
                ProductCategory productCategory = new ProductCategory();
                BeanUtils.copyProperties(category, productCategory);
                categoryService.save(productCategory);
            }


        } catch (SellException e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/category/list");
        map.put("msg", "保存分类成功");
        return new ModelAndView("common/success", map);
    }
}
