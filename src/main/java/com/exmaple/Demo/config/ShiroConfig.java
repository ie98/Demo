package com.exmaple.Demo.config;

//import com.exmaple.Demo.filer.AuthenticationFilter;
import com.exmaple.Demo.filer.CORSAuthenticationFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
//    @Bean
//    public FilterRegistrationBean delegatingFilterProxy(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
//        proxy.setTargetFilterLifecycle(true);
//        proxy.setTargetBeanName("shiroFilter");
//        filterRegistrationBean.setFilter(proxy);
//        return filterRegistrationBean;
//    }
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
//        Map<String, Filter> filters = bean.getFilters();
//        filters.put("authc", new AuthenticationFilter());
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
//        Map<String, Filter> filters = new LinkedHashMap<>();
//        filters.put("authc", new AjaxPermissionsAuthorizationFilter());
//        bean.setFilters(filters);
//        Map<String, Filter> filters = new LinkedHashMap<>();
//        filters.put("corsAuthenticationFilter", corsAuthenticationFilter());
//        bean.setFilters(filters);
//        //添加内置的过滤器 anon authc user perms role
        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/inLeft","perms[101]");
//        filterMap.put("/**", "corsAuthenticationFilter");
//        filterMap.put("/user/add","perms[101]");
//        filterMap.put("/user/update","perms[user:update]");
        filterMap.put("/**","anon");
//        filterMap.put("/adminLogin","anon");
//        filterMap.put("/selectAllUser","authc");
//        filterMap.put("/login","anon");

        bean.setFilterChainDefinitionMap(filterMap);

//            bean.setLoginUrl("/login1");
//        bean.setUnauthorizedUrl("/naouth");

        return bean;
    }


    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager =  new DefaultWebSecurityManager(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean(name = "userRealm")
    public UserRealm getUserRealm(){
        return new UserRealm();
    }

    public CORSAuthenticationFilter corsAuthenticationFilter(){
        return new CORSAuthenticationFilter();
    }
}