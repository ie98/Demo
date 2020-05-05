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
        //=====================user=========
//        filterMap.put("/selectAllUser","perms[100]");
//        filterMap.put("/selectUser","perms[101]");
//
//        filterMap.put("/editUser","perms[102]");
//        filterMap.put("/register","perms[103]");
//        filterMap.put("/user/*","perms[104]");
//
//        filterMap.put("/updateUserState","perms[105]");
//            //=============Admin============
//        filterMap.put("/selectAllAdmin","perms[200]");
//        filterMap.put("/selectAdmin","perms[201]");
//
//        filterMap.put("/editAdmin","perms[202]");
//        filterMap.put("/addAdmin","perms[203]");
//        filterMap.put("/admin/*","perms[204]");
//        filterMap.put("/updateAdminState","perms[205]");
//
//            //===========Role===============
//        filterMap.put("/selectAllRoleAndAuthority","perms[300]");
//        filterMap.put("/allAuthorityTree","perms[300]");
//
//        filterMap.put("/addRole","perms[301]");
//        filterMap.put("/role/*","perms[101]");
//        filterMap.put("/editRole","perms[303]");
//
//        filterMap.put("/selectRole","perms[304]");
//        filterMap.put("/deleteAuthorityByid","perms[305]");
//
//        filterMap.put("/updateAuthority","perms[306]");
//
//            //=================Shop
//        filterMap.put("/selectAllShop","perms[400]");
//        filterMap.put("/addShop","perms[401]");
//        filterMap.put("/shop/*","perms[402]");
//        filterMap.put("/editShop","perms[403]");
//        filterMap.put("/selectShop","perms[404]");
//        filterMap.put("/updateShopState","perms[405]");
//
//            //===================food
//        filterMap.put("/selectAllFood","perms[500]");
//        filterMap.put("/addFood","perms[501]");
//        filterMap.put("/food/*","perms[502]");
//        filterMap.put("/editFood","perms[503]");
//        filterMap.put("/selectFood","perms[504]");
//        filterMap.put("/updateFoodState","perms[505]");
//
//            //=============== sitRecord
//        filterMap.put("/selectAllRecord","perms[600]");
//        filterMap.put("/editRemarks","perms[603]");
//        filterMap.put("/record/*","perms[602]");
//        filterMap.put("/selectRecord","perms[604]");
//
//       //============authotity
//        filterMap.put("/getAllAuthorityList","perms[700]");
//
//            //============FoodRecord
//
//            //============Tag
//        filterMap.put("/getTagTree","perms[900]");
//        filterMap.put("/selectAllTagNotQuery","perms[901]");
//        filterMap.put("/addTag/*","perms[901]");
//
//            //==========allTag
//
//        filterMap.put("/selectAllTag","perms[1000]");




        filterMap.put("/**","anon");


        bean.setFilterChainDefinitionMap(filterMap);

            bean.setLoginUrl("/adminLogin");
        bean.setUnauthorizedUrl("/naouth");

        return bean;
    }


    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("adminRealm") AdminRealm adminRealm){
        DefaultWebSecurityManager defaultWebSecurityManager =  new DefaultWebSecurityManager(adminRealm);
        return defaultWebSecurityManager;
    }

    @Bean(name = "adminRealm")
    public AdminRealm getAdminRealm(){
        return new AdminRealm();
    }

//    public CORSAuthenticationFilter corsAuthenticationFilter(){
//        return new CORSAuthenticationFilter();
//    }
}