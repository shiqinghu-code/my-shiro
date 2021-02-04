package com.qing.hu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
@Configuration
@WebFilter(filterName = "urlFilter", urlPatterns = "/python")// urlPatterns = "/python" 不起作用 
public class UrlFilter implements Filter {
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
 
        System.out.println("----------------------->过滤器被创建");
    }
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String requestURI = req.getRequestURI();
        System.out.println("--------------------->过滤器：请求地址"+requestURI);
        if(!requestURI.contains("info")){
            servletRequest.getRequestDispatcher("/page/error").forward(servletRequest, servletResponse);
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
        System.out.println("--------------------->过滤器：结束");
    }
 
    @Override
    public void destroy() {
 
        System.out.println("----------------------->过滤器被销毁");
    }
}