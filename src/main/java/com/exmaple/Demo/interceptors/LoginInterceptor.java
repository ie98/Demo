package com.exmaple.Demo.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.exmaple.Demo.model.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LoginInterceptor
 * @Description TODO
 * @Author 411头目
 * @Date 2020/6/6 15:50
 * @Version 1.0
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
//        System.out.println(user.getUsername());
        if (user != null){
            System.out.println("放行LOGIN");
            return true;
        }
        System.out.println("拦截LOGIN");
        return false;//返回TRUE才能继续执行

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
//        HttpSession session = request.getSession();
//        System.out.println(session.getAttribute("username"));
//        System.out.println(session.getAttribute("password"));
//        request.getInputStream();
        System.out.println(request.getAttribute("password"));
        System.out.println(request.getParameter("password"));
        System.out.println(request.getParameter("username"));
//        Map map  = request.getParameterMap();
//        System.out.println(map.get("password"));
//        System.out.println(map.get("username"));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion");
    }
}
