//package com.exmaple.Demo.config;
//
//import com.exmaple.Demo.mapper.AdminMapper;
//import com.exmaple.Demo.model.Admin;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
////自定义的UserRealm
//public class AdminRealm extends AuthorizingRealm {
//    @Autowired
//    private AdminMapper adminMapper;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("授权方法");
//        //从认证方法中获取当前的对象
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("user:login");
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("认证方法");
//
//        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
//        Admin admin = adminMapper.selectAdminByName(userToken.getUsername());
//        if ( admin == null){
//            System.out.println("认证失败" );
//            return  null;//自动抛出UnknownAccountException
//        }
//        System.out.println("认证通过" );
//        //SimpleAuthenticationInfo 的第一个参数可以将当前的user对象传递给授权方法
//        //                           第二个参数是自动验证密码，保证密码的安全性
//        return new SimpleAuthenticationInfo(admin,admin.getPassword(),"");
//    }
////    //授权
////    @Override
////    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
////        System.out.println("授权方法");
////        //从认证方法中获取当前的对象
////        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//////        Subject subject = SecurityUtils.getSubject();
//////        Admin admin = (Admin) subject.getPrincipal();
//////        String[] authritys = admin.getAuthority().split(",");
//////
//////        for (String authrity : authritys) {
//////            System.out.println(authrity);
//////            info.addStringPermission(authrity);
//////        }
////            info.addStringPermission("user:edit");
////
////        return info;
//////        return null;
////    }
////
////    //认证
////    @Override
////    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
////        System.out.println("认证方法");
////
////        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
////        Admin admin = adminMapper.selectAdminByName(userToken.getUsername());
////        if ( admin == null){
////            System.out.println("认证失败" );
////            return  null;//自动抛出UnknownAccountException
////        }
////        System.out.println("认证通过" );
////        //SimpleAuthenticationInfo 的第一个参数可以将当前的user对象传递给授权方法
////        //                           第二个参数是自动验证密码，保证密码的安全性
////        return new SimpleAuthenticationInfo(admin,admin.getPassword(),"");
////    }
//
//}
