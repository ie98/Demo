package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.*;
import com.exmaple.Demo.model.Authority;
import com.exmaple.Demo.model.Role;

import java.util.List;

public interface AuthorityService  {
    public List<Authority> getAuthority(String str);
    public QueryReturn selectAllRoleAndAuthority(Query query);
    public QueryReturn getAllAuthorityList(Query query);
    public List<Authority> getAuthorityList(Integer id);
    public AuthorityAndMeta deleteAuthorityByid(RII rii );
    public List<Authority> allAuthorityTree();
}
