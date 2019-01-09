package com.error;

import com.service.ApiService;
import com.service.ApiService1;
import org.springframework.stereotype.Component;

/**
 * @ClassName: com.error.ApiServiceError
 * @Description:
 * @Author:      Administrator
 * @CreateDate: 2019/1/8 8:17
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@Component
public class ApiServiceError1 implements ApiService1 {
    @Override
    public String index() {
        return "服务发生故障！";
    }
}
