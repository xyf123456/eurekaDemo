package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: com.ConfigApplication
 * @Description: 配置中心启动类
 *
 * 通过两种方式搭建配置中心：
 * spring cloud 本地存储：在配置中心引入依赖；配置应用添加@EnableConfigServer注解；
 * 配置配置中心的application.yml,
 * 核心配置active: native；同时  search-locations: classpath:properties/，即
 * 搜索src/main/resource 下的properties文件夹下的文件；在properties中心新建
 * 提供服务应用-开发模式.properties文件，配置该文件注册中心：服务端口号，服务
 * 的名称；去服务模块中配置，首先导入config依赖；删除之前的application.yml，添加
 * bootstrap.yml文件，因为spring cloud 优先读取此文件；在此文件中配置服务端口号，
 * 服务应用名称和配置中心文件保持一致，配置注册中心；spring cloud 中的配置 profile: dev
 * name: eurekaclient，uri: http://127.0.0.1:8888要和配置中心保持一致；endpoints:
enabled: true 开启，这个不开启配置中心；
然后分别开启注册中心、配置中心、服务应用；然后通过配置中心修改服务端口号来看监听服务端口
号的变化，发现通过配置中心也能配置服务端口号；
 * @Author: Administrator
 * @CreateDate: 2019/1/9 15:06
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
    }
}
