package com.liuyuhang.sell.controller;

import com.liuyuhang.sell.dataobject.ProductCategory;
import com.liuyuhang.sell.dataobject.ProductInfo;
import com.liuyuhang.sell.enums.ProductStatusEnum;
import com.liuyuhang.sell.exception.SellException;
import com.liuyuhang.sell.form.ProductForm;
import com.liuyuhang.sell.service.CategoryService;
import com.liuyuhang.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/29 15:59
 * @Description:
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "8") Integer size,
                             Map<String, Object> map) {
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        int showEndPage = page + 5;
        if (productInfoPage.getTotalPages() <= showEndPage) {
            showEndPage = productInfoPage.getTotalPages();
        }

        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("showEndPage", showEndPage);
        // System.out.println(productInfoPage.getContent().get(0).getProductStatusEnum().getMessage());
        return new ModelAndView("product/list", map);
    }


    @GetMapping("/onSale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);

        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);

    }

    @GetMapping("/offSale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);

        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);

    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }
        //查询所有的类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("catagoryList", categoryList);

        return new ModelAndView("product/index", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        ProductInfo productInfo;
        if (StringUtils.isEmpty(form.getProductId())) {
            productInfo = new ProductInfo();
            productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        } else {
            productInfo = productService.findOne(form.getProductId());
        }
        BeanUtils.copyProperties(form, productInfo);
        try {
            productService.save(productInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);


    }

}
