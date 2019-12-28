package com.liuyuhang.sell;

import com.liuyuhang.sell.config.ProjectUrlConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties({
        ProjectUrlConfig.class
})
public class SellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
        log.info("程序启动完成:请打开:http://sell.com打开网页");
    }

}
