package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: com.controller.HelloController
 * @Description: zuul组件的测试,
 * 在实际的项目中，一个项目可能会包含很多个服务，每个服务的端口和 IP
 * 都可能不一样。那么，如果我们以这种形式提供接口给外部调用，代价是非
 * 常大的。从安全性上考虑，系统对外提供的接口应该进行合法性校验，防止
 * 非法请求，如果按照这种形式，那每个服务都要写一遍校验规则，维护起来
 * 也很麻烦。
 * @Author: Administrator
 * @CreateDate: 2019/1/6 10:29
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
@RestController
@RefreshScope //实现手动方式刷新配置的相关依赖
public class HelloController {

    @Value("${server.port}")
    private int port;

    /**
     * @ Description: 向客户端输出Hello World!
     * 当我们修改了服务提供的端口号时，重新开启服务提供者的应用，
     * 通过访问http://localhost:8080/api/index，我们的端口号在不断的
     * 更换，即通过zuul 服务网关会依次请求不同端口，以达到负载均衡的目的。
     * @params:  * @param
     * @return:java.lang.String
     **/
    @RequestMapping("index")
    public String index() {

        return "Hello World!"+port;
    }

    /**
     * @ Description:向客户端输出spring Cloud!
     * 当我们修改了服务提供的端口号时，重新开启服务提供者的应用，
     * 通过访问http://localhost:8080/api/index1，我们的端口号在不断的
     * 更换，即通过zuul 服务网关会依次请求不同端口，以达到负载均衡的目的
     * @params:  * @param
     * @return:java.lang.String
     **/
    @RequestMapping("index1")
    public String index1() {
        return "Hello spring Cloud!"+port;
    }


}
