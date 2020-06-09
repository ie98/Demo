//package com.exmaple.Demo.filer;
//
//import org.apache.shiro.session.mgt.DefaultSessionManager;
//import org.apache.shiro.web.filter.authc.UserFilter;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sound.midi.Soundbank;
//import java.io.IOException;
//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @ClassName CORSFilter
// * @Description TODO
// * @Author 411头目
// * @Date 2020/6/5 23:35
// * @Version 1.0
// **/
//@WebFilter(filterName = "CORSProblem",urlPatterns = "/**")
//public class CORSFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("过滤器被创建。。。。");
////        DefaultWebSessionManager
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("过滤器被销毁。。。");
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("执行过滤器");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        String url = request.getHeader("Origin");//获取请求头中的Origin属性对应值
//        String [] origin = {"http://localhost:9001" , "http://localhost:9000"};
//        Set set = new HashSet(Arrays.asList(origin)); //将string数组转为Set集合，防止重复
//        if (set.contains(url)){
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//            response.setHeader("Access-Control-Allow-Origin", url);  //动态配置"Access-Control-Allow-Origin"属性
//            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//            response.setHeader("Access-Control-Max-Age", "3600");
//            response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
//            response.setHeader("Access-Control-Allow-Credentials", "true");
//        }
//
//            filterChain.doFilter(servletRequest,servletResponse);
//    }
//}
