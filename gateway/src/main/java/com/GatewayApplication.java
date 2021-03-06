package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/**
 * @ClassName: GatewayApplication
 * @Description:  服务网关的应用,Spring Cloud的另一个组件：zuul，它提供微服务的
 * 网关功能，即中转站，通过它提供的接口，可以转发不同的服务。
 * @Author:      Administrator
 * @CreateDate: 2019/1/6 11:25
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
