package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;

@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void  insert (User user);
    @Update("")
    void  Updadte (User user);
    @Delete("")
    void  Delete (int id);
    @Select("select * from user where token = #{token}")
    User findByToken (@Param("token")  String token);
    @Select("select * from user where username = #{username} and password = #{password}")
    User check (@Param("username") String username , @Param("password") String password);
    @Update("update user set token = #{token} where username = #{username}")
    void SetUserToken(@Param("token") String token , @Param("username") String username);
    @Update("update user set token = null where username = #{username}")
    void DeleteUserToken(@Param("token") String token , @Param("username") String username);

}
