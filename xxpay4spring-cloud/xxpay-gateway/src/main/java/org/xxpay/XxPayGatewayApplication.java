package org.xxpay;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingzhiwei jmdhappy@126.com
 * @version V1.0
 * @Description: xxpay网关服务
 * @date 2017-07-05
 * @Copyright: www.xxpay.org
 */
@EnableSwagger2Doc
@EnableZuulProxy
@SpringCloudApplication
public class XxPayGatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(XxPayGatewayApplication.class).web(true).run(args);
    }

//	@Bean
//	public AccessFilter accessFilter() {
//		return new AccessFilter();
//	}

    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List resources = new ArrayList<>();
            resources.add(swaggerResource("xxpay-web", "/api/v2/api-docs", "2.0"));
            resources.add(swaggerResource("xxpay-service", "/notify/v2/api-docs", "2.0"));

            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }

}
