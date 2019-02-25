package org.xxpay.web.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xxpay.common.util.MyBase64;

/**
 * @author dingzhiwei jmdhappy@126.com
 * @version V1.0
 * @Description:
 * @date 2017-07-05
 * @Copyright: www.xxpay.org
 */
@Service
public class PayChannelServiceClient {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "selectPayChannelFallback")
    public String selectPayChannel(String jsonParam) {
        return restTemplate.getForEntity("http://localhost:2000/pay_channel/select?jsonParam=" + MyBase64.encode(jsonParam.getBytes()), String.class).getBody();
    }

    public String selectPayChannelFallback(String jsonParam) {
        return "error";
    }

}