package org.xxpay.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author dingzhiwei jmdhappy@126.com
 * @version V1.0
 * @Description: xxpay服务注册中心
 * @date 2017-07-05
 * @Copyright: www.xxpay.org
 */
@EnableEurekaServer
@SpringBootApplication
public class XxPayServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(XxPayServerApplication.class).web(true).run(args);
    }

}
