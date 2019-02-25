package org.xxpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author dingzhiwei jmdhappy@126.com
 * @version V1.0
 * @Description: xxpay配置中心服务端
 * @date 2017-07-05
 * @Copyright: www.xxpay.org
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class XxPayConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(XxPayConfigApplication.class, args);
    }
}
