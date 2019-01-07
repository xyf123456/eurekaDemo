package com.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eurekaclient")
public interface ApiService1 {

    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    String index();
}
