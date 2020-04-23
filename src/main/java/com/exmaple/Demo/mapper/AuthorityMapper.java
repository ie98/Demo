package com.exmaple.Demo.mapper;

import com.exmaple.Demo.dto.UpdateAuthority;
import com.exmaple.Demo.model.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface AuthorityMapper {
    @Select("select * from authority")
    List<Authority> selectAllAuthority();
    @Select("select * from authority where authorityid = #{authorityid}")
    Authority selectAuthorityByAutoId(@Param("authorityid") int authorityid);
    @Select("select authorityid from authority   ORDER BY authorityid")
    List<Integer> allAuthorityid();

}
