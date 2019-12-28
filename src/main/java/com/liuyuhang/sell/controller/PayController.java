package com.liuyuhang.sell.controller;

import com.liuyuhang.sell.dto.OrderDto;
import com.liuyuhang.sell.enums.ResultEnum;
import com.liuyuhang.sell.exception.SellException;
import com.liuyuhang.sell.service.OrderService;
import com.liuyuhang.sell.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/25 18:11
 * @Description:
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String order,
                               @RequestParam("returnUrl") String returnUrl, Map<String, Object> map) {
        OrderDto orderDto = orderService.findOne(order);
        if (orderDto == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //  发起支付
        //  PayResponse payResponse = payService.create(orderDto);
        // map.put("payResponse",payResponse);
        map.put("returnUrl", "http://sell.com/#/order/" + order);
        orderService.paid(orderDto);
        //发起支付 TODO 这里无法注册商用公众号 故直接返回成功
        return new ModelAndView("pay/success", map);
    }
}
