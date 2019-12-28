package com.liuyuhang.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/25 15:02
 * @Description:
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WexinController {
    //private  static  final  String openid = "oTgZpweNnfivA9ER9EIXoH-jlrWQ";
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法");
        log.info("code = {}", code);
        String url = "https://api.weixin.qq.com/sns/oauth2/accee_token?xxxxx"; //微信公众账号会有 //TODO
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response = {}", response);
    }
}
