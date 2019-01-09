package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: Application
 * @Description: eureka服务注册中心主入口（一个 module 为服务注册中心）
 * @Author:      Administrator
 * @CreateDate: 2019/1/5 0005 下午 10:31
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@SpringBootApplication
//@EnableDiscoveryClient  // 在注册中心发现服务
@EnableEurekaClient
public class ApplicationProvider {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationProvider.class, args);
    }
}
