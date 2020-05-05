package com.exmaple.Demo.mapper;

import com.exmaple.Demo.dto.RegisterUser;
import com.exmaple.Demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void  insert (User user);
    @Update("update user set username = #{username} , password = #{password} , college = #{college} , phone = #{phone}, grade = #{grade} where id = #{id}")
    Boolean  editUser (User user);
    @Delete("delete from user where id = #{id}")
    Boolean deleteUser (@Param("id") int id);
    @Select("select * from user where token = #{token} and id = #{id}")
    User tokenCheck (@Param("token")  String token , @Param("id") int id);
    @Select("select * from user where  id = #{id}")
    User findById (@Param("id") int id);
    @Select("select * from user where username = #{username} and password = #{password}")
    User check (@Param("username") String username , @Param("password") String password);
    @Update("update user set token = #{token} where username = #{username}")
    void SetUserToken(@Param("token") String token , @Param("username") String username);
    @Update("update user set token = null where username = #{username}")
    void DeleteUserToken(@Param("token") String token , @Param("username") String username);
    @Insert("insert into user (username ,password,college,grade,phone)values(#{username},#{password},#{college},#{grade},#{phone})")
    void insertUser(RegisterUser registerUser);
    @Select("select username from user where username = #{username}")
    String checkRegisterName (@Param("username")  String username);
    @Select("select * from user")
    List<User> selectAllUser ();
    @Update("update user set state = not state where id = #{id} ")
    Boolean updateState(@Param("id") int id);
    @Select("select * from user where username = #{name}")
    User selectUserByName(@Param("name") String name);
    @Select("select * from user where username = #{username} and id <> #{id}")
    List<User> selectUserByNameAndId(@Param("username") String name , @Param("id") int id);
    @Update("update user set password = #{password} where id = #{id}")
    Boolean updatePassword(@Param("password") String password , @Param("id") int id);

}
