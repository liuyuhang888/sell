package com.liuyuhang.sell.controller;

import com.liuyuhang.sell.dto.OrderDto;
import com.liuyuhang.sell.enums.ResultEnum;
import com.liuyuhang.sell.exception.SellException;
import com.liuyuhang.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/26 09:58
 * @Description:
 */

@Slf4j
@RequestMapping("/seller/order")
@Controller
public class SellerOrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 功能描述:
     *
     * @param page :第几页
     * @param size :一页有多少条数据
     * @return: org.springframework.web.servlet.ModelAndView
     * @auther: liuyuhang
     * @date: 2019/11/26 10:01
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "8") Integer size,
                             Map<String, Object> map) {


        PageRequest pageRequest = new PageRequest(page - 1, size, new Sort(Sort.Direction.DESC, "createTime"));
        Page<OrderDto> orderDtoPage = orderService.findList(pageRequest);
        int showEndPage = page + 5;
        if (orderDtoPage.getTotalPages() <= showEndPage) {
            showEndPage = orderDtoPage.getTotalPages();
        }
        map.put("orderDtoPage", orderDtoPage);
        map.put("currentPage", page);
        map.put("showEndPage", showEndPage);
        return new ModelAndView("order/list", map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId, Map<String, Object> map) {
        OrderDto one;
        try {
            one = orderService.findOne(orderId);
            orderService.cancel(one);

        } catch (SellException e) {
            log.error("【卖家端取消订单】 发生异常");

            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");

            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS);
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");


    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        OrderDto orderDto;
        try {
            orderDto = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("买家订单详情发生异常", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS);
        map.put("url", "/sell/seller/order/list");
        map.put("orderDto", orderDto);
        return new ModelAndView("order/detail", map);
    }

    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        OrderDto orderDto;
        try {
            orderDto = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("买家订单完成发生异常", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        orderService.finish(orderDto);
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }


}
