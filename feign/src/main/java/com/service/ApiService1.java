package com.service;

import com.error.ApiServiceError1;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eurekaclient",fallback = ApiServiceError1.class)
public interface ApiService1 {

    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    String index();
}
