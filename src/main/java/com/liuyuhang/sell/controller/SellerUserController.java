package com.liuyuhang.sell.controller;

import com.liuyuhang.sell.constant.RedisConstant;
import com.liuyuhang.sell.dataobject.SellerInfo;
import com.liuyuhang.sell.enums.ResultEnum;
import com.liuyuhang.sell.service.SellerService;
import com.liuyuhang.sell.utils.serializer.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 刘宇航
 * @Date: 2019/12/9 23:05
 * @Description:
 */
@Controller
@RequestMapping("seller/user")
public class SellerUserController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/loginPage")
    public ModelAndView loginPage() {
        return new ModelAndView("user/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(SellerInfo sellerInfo, Map<String, Object> map, HttpServletResponse response, HttpServletRequest request) {
        SellerInfo login = sellerService.login(sellerInfo);
        if (login == null) {
            map.put("msg", "账号或密码错误");
            map.put("url", "/sell/seller/user/login");
            new ModelAndView("common/error", map);
        }
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, "username"), sellerInfo.getUsername(), expire, TimeUnit.SECONDS);
        CookieUtil.set(response, String.format(RedisConstant.TOKEN_PREFIX, "username"), sellerInfo.getUsername(), RedisConstant.EXPIRE);
        return new ModelAndView("redirect:".concat("http://sell.com").concat("/sell/seller/order/list"));
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, String.format(RedisConstant.TOKEN_PREFIX, "username"));
        if (cookie != null) {
            //2. 清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, "username"));

            //3. 清除cookie
            CookieUtil.set(response, String.format(RedisConstant.TOKEN_PREFIX, "username"), null, 0);
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }
}
