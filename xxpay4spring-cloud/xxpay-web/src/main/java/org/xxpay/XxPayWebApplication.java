package org.xxpay;

import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dingzhiwei jmdhappy@126.com
 * @version V1.0
 * @Description: xxpay支付产品服务, 提供各商户支付产品接口
 * @date 2017-07-05
 * @Copyright: www.xxpay.org
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
@EnableFeignClients
@EnableCircuitBreaker
public class XxPayWebApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(XxPayWebApplication.class, args);
    }

    @RestController
    class AaaController {
        @Autowired
        DiscoveryClient discoveryClient;

        @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
        @GetMapping("/service-a")
        public String dc() {
            String services = "Services: " + discoveryClient.getServices();
            System.out.println(services);
            return services;
        }

        @ApiOperation(value = "保存信息", notes = "获取页面填写的用户信息，保存信息")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "email", value = "用户email", required = true, dataType = "String"),
                @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String")
        })
        @PostMapping("/service-a")
        public String getUser2Save(String email, String name) {
            return "Services: " + discoveryClient.getServices();
        }
    }
}
