package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @ClassName: com.Application
 * @Description: Feign 是一个声明式的 HTTP 客户端，它简化了 HTTP 客户端的开发。
 * 使用 Feign，只需要创建一个接口并注解，就能很轻松的调用各服务提供的 HTTP 接口。
 * Feign 默认集成了 Ribbon，默认实现了负载均衡。
 * @Author:      Administrator
 * @CreateDate: 2019/1/7 15:58
 * @UpdateUser:   Administrator 
 * @Version:        1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
