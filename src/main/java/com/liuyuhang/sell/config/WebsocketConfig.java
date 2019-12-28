package com.liuyuhang.sell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.io.Serializable;

/**
 * @Auther: 刘宇航
 * @Date: 2019/12/10 10:19
 * @Description:
 */

@Configuration
public class WebsocketConfig implements Serializable {


    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
