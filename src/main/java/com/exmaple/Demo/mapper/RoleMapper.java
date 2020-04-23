package com.exmaple.Demo.mapper;

import com.exmaple.Demo.dto.UpdateAuthority;
import com.exmaple.Demo.model.Role;
import com.exmaple.Demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Component
@Mapper
public interface RoleMapper {
    @Select("select * from role ")
    public List<Role> selectAllRole();
    @Select("select * from role where id = #{id}")
    public Role selectOneById(@Param("id")int id);
    @Select("select authority from role where id = #{id}")
    public String selectAuthorityById(@Param("id") int id);
    @Update("update role set authority = #{authority} where id = #{id}")
    Boolean deleteAuthorityById(@Param("id") int id,@Param("authority") String authority);
    @Update("update role set authority = #{newAuthority} where id = #{roleId}")
    Boolean UpdateAuthority(UpdateAuthority updateAuthority);
    @Delete("delete from role where id = #{id}")
    Boolean deleteRoleById(@Param("id") int id);
    @Update("update role set name = #{name} , detail = #{detail} where id = #{id}")
    Boolean UpdateInfo(@Param("name") String name , @Param("detail") String detail , @Param("id") int id);
    @Insert("insert into role (name ,detail) values (#{name} , #{detail})")
    Boolean insertRole(@Param("name") String name , @Param("detail") String detail);
    @Select("select * from role where name = #{name}")
    Role selectRoleByName(@Param("name") String name);
    @Select("select * from user where name = #{name} and id <> #{id}")
    List<Role> selectRoleByNameAndId(@Param("name") String name , @Param("id") int id);

}
