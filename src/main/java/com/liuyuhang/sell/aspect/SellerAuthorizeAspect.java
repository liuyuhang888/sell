package com.liuyuhang.sell.aspect;

import com.liuyuhang.sell.constant.RedisConstant;
import com.liuyuhang.sell.exception.SellAuthorizeException;
import com.liuyuhang.sell.utils.serializer.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 刘宇航
 * @Date: 2019/12/9 22:22
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.liuyuhang.sell.controller.Seller*.*(..))" +
            "&& !execution(public * com.liuyuhang.sell.controller.SellerUserController.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //查询cookie
        Cookie cookie = CookieUtil.get(request, String.format(RedisConstant.TOKEN_PREFIX, "username"));
        if (cookie == null) {
            log.warn("[登录检验] Cookie中查不到Token");
            throw new SellAuthorizeException();
        }
        //查询rides
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, "username"));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("[登录校验]Redis中查不到token");
            throw new SellAuthorizeException();
        }
    }
}
