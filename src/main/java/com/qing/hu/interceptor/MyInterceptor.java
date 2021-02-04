package com.qing.hu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class MyInterceptor implements HandlerInterceptor{

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("==========进入拦截器===");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println(username +","+password);
        
        return true;
        
//        if("xiongda".equals(username) && "123456".equals(password)) {
//            return true;
//        }else {
//            return false;
//        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("================= 拦截器 后置调用 ===============");
    }

}