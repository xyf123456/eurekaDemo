package com;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: com.Application
 * @Description: Feign 是一个声明式的 HTTP 客户端，它简化了 HTTP 客户端的开发。
 * 使用 Feign，只需要创建一个接口并注解，就能很轻松的调用各服务提供的 HTTP 接口。
 * Feign 默认集成了 Ribbon，默认实现了负载均衡。
 * 。一个大型的系统由多个微服务模块组成，各模块之间不可避免需要进行通信，一般我
 * 们可以通过内部接口调用的形式，服务 A 提供一个接口，服务 B 通过 HTTP 请求调用
 * 服务 A 的接口，为了简化开发，Spring Cloud 提供了一个基础组件方便不同服务之间
 * 的 HTTP 调用，那就是 Feign。
 * @EnableEurekaClient：到注册中心注册
 * @EnableFeignClients：如果我们要使用 Feign 声明式 HTTP 客户端，必须要在启动
 * 类加入这个注解，以开启 Feign。
 * @EnableHystrixDashboard：开启熔断器，进行监测
 * Hystrix 给我们提供了一个强大的功能，那就是 Dashboard。Dashboard 是一个 Web 界
 * 面，它可以让我们监控 Hystrix Command 的响应时间、请求成功率等数据。
 * @Author:      Administrator
 * @CreateDate: 2019/1/7 15:58
 * @UpdateUser:   Administrator 
 * @Version:        1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableDiscoveryClient
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * @ Description: 实现通过 Hystrix监控 Command 的响应时间、请求成功率等数据。
     * @params:  * @Param:
     * @return:org.springframework.boot.web.servlet.ServletRegistrationBean
     **/
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
