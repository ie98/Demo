//package com.exmaple.Demo.filer;
//
//import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
//import org.apache.shiro.web.util.WebUtils;
//import org.springframework.core.annotation.Order;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//@Order(1)
//@WebFilter(filterName = "myFilter", urlPatterns = "/*", initParams = {
//        @WebInitParam(name = "URL", value = "http://localhost:8088") //可有可无
//})
//public class AuthenticationFilter extends FormAuthenticationFilter {
//
//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        HttpServletResponse httpResp = WebUtils.toHttp(response);
//        HttpServletRequest httpReq = WebUtils.toHttp(request);
//
//        /*系统重定向会默认把请求头清空，这里通过拦截器重新设置请求头，解决跨域问题*/
//        httpResp.addHeader("Access-Control-Allow-Origin", httpReq.getHeader("Origin"));
//        httpResp.addHeader("Access-Control-Allow-Headers", "*");
//        httpResp.addHeader("Access-Control-Allow-Methods", "*");
//        httpResp.addHeader("Access-Control-Allow-Credentials", "true");
//        //该处的/toLogin在前端配置对应的跳转到登陆页面的方法即可
////        httpReq.sendRedirect("/toLogin");
//        return false;
//    }
//
//}