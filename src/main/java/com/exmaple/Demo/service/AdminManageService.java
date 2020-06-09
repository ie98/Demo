package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.Meta;

import com.exmaple.Demo.dto.RemarksAndId;
import com.exmaple.Demo.model.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

public interface AdminManageService {
    public Meta deleteUser(int id);
    public Meta editUser(User user);
    public Meta editRemarks(RemarksAndId remarks);
    public Meta deleteRecord(int id);
    public Meta editShop(Shop shop);
    public Meta deleteShop(int id);
    public Meta editFood(Food food);

    public Meta deleteFood(int id);
//    public Meta addUser(User user);
    public Meta addAdmin(Admin admin);
    public Meta addShop(Shop shop );
    public Meta addFood(Food food );
    public void uploadImg(MultipartFile file ,String foodname ,String shopname) throws IOException;
    public Meta deleteRole(int id);
    public Meta addRole(Role role );
    public Meta editRole(Role role);
    public Meta disposeFoodRecord(Integer id , Integer userid);
    public Meta confirmDisposeFoodRecord(Integer id);

}
