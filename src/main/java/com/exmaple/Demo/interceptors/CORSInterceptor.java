package com.exmaple.Demo.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CORSInterceptor
 * @Description TODO
 * @Author 411头目
 * @Date 2020/6/7 10:20
 * @Version 1.0
 **/
@Component
public class CORSInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request1, HttpServletResponse response1, Object handler) throws Exception {
        System.out.println("CORS拦截器");

        HttpServletRequest request = (HttpServletRequest) request1;
        String url = request.getHeader("Origin");//获取请求头中的Origin属性对应值
        String [] origin = {"http://localhost:9001" , "http://localhost:9000"};
        Set set = new HashSet(Arrays.asList(origin)); //将string数组转为Set集合，防止重复
        if (set.contains(url)){
            System.out.println(url);
            HttpServletResponse response = (HttpServletResponse) response1;
            response.setHeader("Access-Control-Allow-Origin", url);  //动态配置"Access-Control-Allow-Origin"属性
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,application/json,content-type");
            response.setHeader("Access-Control-Allow-Credentials", "true");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
