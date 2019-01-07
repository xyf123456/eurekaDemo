package com.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: com.service.ApiService
 * @Description:  提供服务的接口
 * @Author:      Administrator
 * @CreateDate: 2019/1/7 16:00
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@FeignClient(value = "eurekaclient")
public interface ApiService {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    String index();
}
