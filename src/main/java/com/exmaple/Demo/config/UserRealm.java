//package com.exmaple.Demo.config;
//
//import com.exmaple.Demo.mapper.AdminMapper;
//import com.exmaple.Demo.mapper.UserMapper;
//import com.exmaple.Demo.model.Admin;
//import com.exmaple.Demo.model.User;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class UserRealm  extends AuthorizingRealm {
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("授权方法");
//        //从认证方法中获取当前的对象
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("101");
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("认证方法");
//
//        UsernamePasswordToken  userToken= (UsernamePasswordToken) token;
//        User user = userMapper.selectUserByName(userToken.getUsername());
//        if ( user == null){
//            System.out.println("认证失败" );
//            return  null;//自动抛出UnknownAccountException
//        }
//        System.out.println("认证通过" );
////        SimpleAuthenticationInfo 的第一个参数可以将当前的user对象传递给授权方法
////                                   第二个参数是自动验证密码，保证密码的安全性
////        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
////        String username = "root";
////        String password = "123456";
//
//
//
//
//
//       UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
//       System.out.println(usertoken.getUsername());
//       if (!usertoken.getUsername().equals(user.getUsername())){
//           System.out.println("认证失败");
//           return null;
//       }
//return new SimpleAuthenticationInfo("",user.getPassword(),"");
////        return null;
//
//    }
//}
