package com.service;

import com.FeignApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: com.service.ApiServiceTest
 * @Description: 分别启动注册中心 EurekaServer、服务提供者EurekaClient（
 * 这里服务提供者启动两次，端口分别为8762、8763，以观察 Feign 的负载均衡效果）。
 * @Author: Administrator
 * @CreateDate: 2019/1/7 16:13
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
@SpringBootTest(classes = FeignApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ApiServiceTest {

    @Autowired
    private ApiService apiService;


    /**
     * @ Description:由此可见，我们成功调用了服务提供者提供的接口，并且循环调用不同的接口，
     * 说明它自带了负载均衡效果。
     * @params: * @Param:
     * @return:void
     **/
    @Test
    public void test() {

        try {
            System.out.println(apiService.index());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}