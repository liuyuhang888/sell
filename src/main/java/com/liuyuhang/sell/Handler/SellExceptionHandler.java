package com.liuyuhang.sell.Handler;

import com.liuyuhang.sell.config.ProjectUrlConfig;
import com.liuyuhang.sell.exception.SellAuthorizeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: 刘宇航
 * @Date: 2019/12/9 22:35
 * @Description:
 */
@ControllerAdvice
@Slf4j
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    @ExceptionHandler(value = SellAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        log.warn("登录异常,跳转重新登录");
        return new ModelAndView("redirect:".concat(projectUrlConfig.getSell()).concat("/sell/seller/user/loginPage"));
    }
}
