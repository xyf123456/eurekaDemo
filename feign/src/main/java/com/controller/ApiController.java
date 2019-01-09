package com.controller;

import com.service.ApiService;
import com.service.ApiService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: com.controller.ApiController
 * @Description:  测试熔断器
 * @Author:      Administrator
 * @CreateDate: 2019/1/8 8:19
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;
    @Autowired
    private ApiService1 apiService1;

    @RequestMapping("index")
    public String index(){
        return apiService.index();
    }

    @RequestMapping("index1")
    public String index1(){
        return apiService1.index();
    }
}
