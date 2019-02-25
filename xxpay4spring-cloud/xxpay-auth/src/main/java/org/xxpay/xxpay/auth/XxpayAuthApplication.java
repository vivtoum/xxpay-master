package org.xxpay.xxpay.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class XxpayAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxpayAuthApplication.class, args);
    }

}
