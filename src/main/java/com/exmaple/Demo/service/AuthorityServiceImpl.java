package com.exmaple.Demo.service;

import com.alibaba.druid.sql.visitor.functions.If;
import com.exmaple.Demo.constant.ResultCode;
import com.exmaple.Demo.dto.*;
import com.exmaple.Demo.mapper.AdminMapper;
import com.exmaple.Demo.mapper.AuthorityMapper;
import com.exmaple.Demo.mapper.RoleMapper;
import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.model.Authority;
import com.exmaple.Demo.model.Role;
import com.exmaple.Demo.util.BubbleSort;
import com.exmaple.Demo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthorityMapper authorityMapper;
    @Autowired
    private AdminMapper adminMapper;
    private Utils utils = new Utils();
    @Override
    public List<Authority> getAuthority(String str){
//        String str =  roleMapper.selectAuthorityById(id);
        if (str == null || str == ""){
            return null;
        }
        String [] autoId = str.split(",");
        int[] authorityId = new int[autoId.length];
        for (int i = 0; i < autoId.length; i++) {  //String转int
            authorityId[i] = Integer.parseInt(autoId[i]);
        }
        BubbleSort.sort(authorityId);  // 必须先排序
//        for (int i = 0; i < authorityId.length; i++) {
//            System.out.print(authorityId[i]);
//        }
        List<Authority> authoritys = new ArrayList<>();
        int[] map = new int[20];//映射表，表示主权限的位置 限制权限的范围为 100-2000 排序后可有可无
        for (int i = 0; i < map.length; i++) { //初始化
            map[i] = 999;
        }
        int index = 0;//authoritys的索引
        for (int i = 0; i < authorityId.length; i++) {
            index = strToObjectUtil(authorityId[i],authoritys,index,map);
        }
        return authoritys;
    }

    @Override
    public QueryReturn getAllAuthorityList(Query query){
        List<Authority> authorities = authorityMapper.selectAllAuthority();
        return utils.selectUtil(authorities,query);
    }
    @Override
    public QueryReturn selectAllRoleAndAuthority(Query query){
            List<Role> roles = roleMapper.selectAllRole();
        for (int i = 0; i < roles.size(); i++) {
            roles.get(i).setAuthorities(this.getAuthority(roles.get(i).getAuthority()));
        }
//        System.out.println(roles.size());
//        System.out.println(query.getPageSize());
        return utils.selectUtil(roles,query);
    }
    @Override
    public List<Authority> getAuthorityList(Integer id){
        if (id != null){
            int auto = adminMapper.getAuthorityById(id);
//            System.out.println(auto);
//            System.out.println(roleMapper.selectAuthorityById(auto));
//            System.out.println(this.getAuthority(roleMapper.selectAuthorityById(auto)));
            return this.getAuthority(roleMapper.selectAuthorityById(auto));
        }
        else return null;

    }

    @Override
    public AuthorityAndMeta deleteAuthorityByid(RII rii ) {
        Role role = roleMapper.selectOneById(rii.getRole().getId());
        int fatherId  = rii.getFatherId();
        int sonId = rii.getSonId();
//        System.out.println(fatherId+"--"+sonId);
        List<Authority> authorities = this.getAuthority(role.getAuthority());

        for (int i = 0; i < authorities.size(); i++) {

            if (authorities.get(i).getAuthorityid()  == fatherId){
                for (int i1 = 0; i1 < authorities.get(i).getSon().size(); i1++) {
                    if (authorities.get(i).getSon().get(i1).getAuthorityid() == sonId){
                        List<Authority> temp = new ArrayList<>();
                        temp.add(authorities.get(i).getSon().get(i1));
                        authorities.get(i).getSon().removeAll(temp);
                        break;
                    }
                }
                if (authorities.get(i).getSon().size() == 0){
                    authorities.remove(authorities.get(i));
                }
            }
        }
        String str = "";
        for (int i = 0; i < authorities.size(); i++) {
            str+= authorities.get(i).getAuthorityid();
            str += ",";
            for (int i1 = 0; i1 < authorities.get(i).getSon().size(); i1++) {
                str += authorities.get(i).getSon().get(i1).getAuthorityid();
                if (i != authorities.size()-1){
                    str += ",";
                }else if (i == authorities.size()-1 && i1 != authorities.get(i).getSon().size() -1){
                    str += ",";
                }

            }
        }
//        System.out.println("11111111111111");
//        System.out.println(str);
        Boolean bool = roleMapper.deleteAuthorityById(role.getId(),str);
        List<Authority> authorities1 = this.getAuthority(str);
        return bool==true?new AuthorityAndMeta(authorities1,new Meta("SUCCESS")):
                new AuthorityAndMeta(new ArrayList<>(), new Meta("ERROR"));
    }
    public List<Authority> allAuthorityTree(){
            List<Integer> authorityid = authorityMapper.allAuthorityid();
            String str = "";
        for (int i = 0; i < authorityid.size(); i++) {
            str += authorityid.get(i);
            if (i != authorityid.size()-1)
                str += ",";
        }
        return this.getAuthority(str);
    }
    public Meta updateAuthority(UpdateAuthority updateAuthority){
        Boolean bool = roleMapper.UpdateAuthority(updateAuthority);
        return bool == true?
                new Meta("SUCCESS"):
                new Meta("ERROR");
    }
    public String getAuthorityString(int id){
        int auto = adminMapper.getAuthorityById(id);
        return roleMapper.selectAuthorityById(auto);
    }
    public int strToObjectUtil(int autoid,List<Authority> authoritys , int index , int[] map){
        if (autoid %100 != 0){
            authoritys.get(map[autoid /100]).getSon().add(authorityMapper.selectAuthorityByAutoId(autoid));
        }else {
            authoritys.add(authorityMapper.selectAuthorityByAutoId(autoid));
            map[autoid /100] = index; //映射表 每次遇到权限头时 放入map
            index++;
        }
        return index;
    }
}
