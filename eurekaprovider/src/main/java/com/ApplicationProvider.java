package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: Application
 * @Description: eureka服务注册中心主入口（一个 module 为服务注册中心）
 * @Author:      Administrator
 * @CreateDate: 2019/1/5 0005 下午 10:31
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class ApplicationProvider {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationProvider.class, args);
    }
}
