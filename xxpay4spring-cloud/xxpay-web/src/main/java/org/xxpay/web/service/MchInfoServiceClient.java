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
public class MchInfoServiceClient {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "selectMchInfoFallback")
    public String selectMchInfo(String jsonParam) {
        return restTemplate.getForEntity("http://localhost:2000/mch_info/select?jsonParam=" + MyBase64.encode(jsonParam.getBytes()), String.class).getBody();
    }

    public String selectMchInfoFallback(String jsonParam) {
        return "error";
    }

}