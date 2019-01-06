package com.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName: com.netflix.zuul.ZuulFilter
 * @Description: 前面我们提到，服务网关还有个作用就是接口的安全性校验，
 * 这个时候我们就需要通过 zuul 进行统一拦截，zuul 通过继承过滤器
 * ZuulFilter 进行处理
 * @Author:      Administrator
 * @CreateDate: 2019/1/6 0006 下午 11:10
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@Component
public class ApiFilter extends ZuulFilter {
    /**
     * @ Description: filterType 为过滤类型，可选值有 pre（路由之前）、
     * routing（路由之时）、post（路由之后）、error（发生错误时调用）。
     * @params:  * @param
     * @return:java.lang.String
     **/
    @Override
    public String filterType() {

        return "pre";
    }
    /**
     * @ Description: filterOrdery 为过滤的顺序，如果有多个过滤器，
     * 则数字越小越先执行
     * @params:  * @param
     * @return:int
     **/
    @Override
    public int filterOrder() {

        return 0;
    }
    /**
     * @ Description: shouldFilter 表示是否过滤，
     * 这里可以做逻辑判断，true 为过滤，false 不过滤
     * @params:  * @param
     * @return:boolean
     **/
    @Override
    public boolean shouldFilter() {

        return true;
    }
    /**
     * @ Description: run 为过滤器执行的具体逻辑，在这里可以做很多事情，
     * 比如：权限判断、合法性校验等。
     * @params:  * @param
     * @return:java.lang.Object
     **/
    @Override
    public Object run() {
        //这里写校验代码
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if (!"123456".equals(token)){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is invalid.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
