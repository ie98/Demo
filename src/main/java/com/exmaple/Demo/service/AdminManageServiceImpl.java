package com.exmaple.Demo.service;

import com.exmaple.Demo.config.WebSocket;
import com.exmaple.Demo.constant.ResultCode;
import com.exmaple.Demo.dto.Meta;

import com.exmaple.Demo.dto.RemarksAndId;
import com.exmaple.Demo.mapper.*;
import com.exmaple.Demo.model.*;
import com.exmaple.Demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class AdminManageServiceImpl implements  AdminManageService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private FoodRecordMapper foodRecordMapper;
    @Autowired
    private WebSocket webSocket;
    /*----------------------------User--------------------*/
    public Meta deleteUser(int id){
        Boolean bool = userMapper.deleteUser(id);
        System.out.println("1");
        return bool==true?new Meta("USER_DELETE_SUCCESS"):
                new Meta("USER_DELETE_ERROR");
    }
    public Meta editUser(User user){
        if (userMapper.selectUserByNameAndId(user.getUsername() , user.getId()).size() != 0){
            System.out.println(userMapper.selectUserByNameAndId(user.getUsername() , user.getId()).get(0).toString());
            return new Meta("USER_HAS_EXISTED");

        }

        Boolean bool =  userMapper.editUser(user);
        return bool==true?new Meta("EDIT_SUCCESS"):
                new Meta("EDIT_ERROR");

    }
    /*----------------------------------Admin----------------------*/
    public Meta deleteAdmin(int id){
        Boolean bool = adminMapper.deleteAdmin(id);
        System.out.println("1");
        return bool==true?new Meta("USER_DELETE_SUCCESS"):
                new Meta("USER_DELETE_ERROR");
    }
    public Meta editAdmin(Admin admin){
        if (adminMapper.selectAdminByNameAndId(admin.getUsername() , admin.getId()).size() != 0){
            System.out.println(adminMapper.selectAdminByNameAndId(admin.getUsername() , admin.getId()).get(0).toString());
            return new Meta("USER_HAS_EXISTED");

        }

        Boolean bool =  adminMapper.editAdmin(admin);
        return bool==true?new Meta("EDIT_SUCCESS"):
                new Meta("EDIT_ERROR");

    }
    @Override
    public Meta addAdmin(Admin admin){
        if (adminMapper.selectAdminByName(admin.getUsername()) != null){
            return new Meta("USER_HAS_EXISTED");
        }
        Boolean bool =  adminMapper.addAdmin(admin);
        return bool==true?new Meta("EDIT_SUCCESS"):
                new Meta("EDIT_ERROR");

    }
    //===========================Remarks
    @Override
    public Meta editRemarks(RemarksAndId remarks){
        System.out.println(remarks.getRemarks());
        System.out.println(remarks.getId());
        Boolean bool = recordMapper.editRemarks(remarks);
        return bool == true?new Meta("SUCCESS"):new Meta("ERROR");
    }

    @Override
    public Meta deleteRecord(int id) {
        return recordMapper.deleteRecrdById(id) == true?new Meta("SUCCESS"):new Meta("ERROR");
    }

    //=======================Shop
    public   Meta addShop(Shop shop){
        if (shopMapper.selectShopByName(shop.getShopname()) != null){
            return new Meta("SHOP_HAS_EXISTED");
        }
        Boolean bool =  shopMapper.insertShop(shop);
        return bool==true?new Meta("SUCCESS"):
                new Meta("ERROR");
    }

    @Override
    public Meta editShop(Shop shop){
        if (shopMapper.selectShopByNameAndId(shop.getShopname(),shop.getId()) != null){
            return new Meta("ERROR");
        }
        Boolean bool = shopMapper.updateShop(shop);
        return bool==true?new Meta("EDIT_SUCCESS"):
                new Meta("EDIT_ERROR");
    }

    @Override
    public Meta deleteShop(int id) {
        return shopMapper.deleteShop(id) == true?new Meta("SUCCESS"):new Meta("ERROR");
    }

    //=========================Food
    @Override
    public   Meta addFood(Food food){
        if (foodMapper.selectFoodByName(food.getFoodname()) != null){
            return new Meta("FOOD_HAS_EXISTED");
        }
        Boolean bool =  foodMapper.insertFood(food);
        return bool == true?new Meta("SUCCESS"):new Meta("ERROR");
    }
    @Override
    public Meta editFood(Food  food ){
        Boolean bool = foodMapper.updateFood(food);

        return bool==true?new Meta("EDIT_SUCCESS"):
                new Meta("EDIT_ERROR");
    }

    @Override
    public Meta deleteFood(int id) {
        return foodMapper.deleteFood(id) == true?new Meta("SUCCESS"):new Meta("ERROR");
    }

    @Override
    public void uploadImg(MultipartFile file, String foodname ,String shopname) throws IOException {
        System.out.println(foodname);
        System.out.println(shopname);
        File folder = new File("D:\\convenientCT\\imgs\\" + shopname);
//        if (countFileNumber(folder) > MAX_IMAGE_NUM) {
//            return MAX_IMAGE_NUM;
//        }
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        System.out.println(folder.getAbsolutePath());

        String last ;

        if (!file.isEmpty()) {
            last = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);

            String fileName = foodname + "."+ last;
            InputStream is = file.getInputStream();

            if (!folder.exists()) {
                folder.mkdirs();
            }

            File uploadFile = new File(folder.getAbsolutePath() + File.separator + fileName);
            try (BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(uploadFile))) {
                outputStream.write(file.getBytes());
            }catch (Exception e){
                System.out.println("ERROR");
            }
            foodMapper.updateImg(foodname,fileName);

        }

    }
    //===============================Role

    @Override
    public Meta deleteRole(int id) {
        return roleMapper.deleteRoleById(id) == true ?new Meta("SUCCESS"):new Meta("ERROR");
    }

    @Override
    public Meta addRole(Role role) {
        if (roleMapper.selectRoleByName(role.getName()) != null){
            return new Meta("ROLE_HAS_EXISTED");
        }
        return Result.ResuleInfo(roleMapper.insertRole(role.getName(),role.getDetail()));
    }

    @Override
    public Meta editRole(Role role) {
        if (roleMapper.selectRoleByNameAndId(role.getName(),role.getId()).size() !=0){
            return new Meta("ROLE_HAS_EXISTED");
        }
        return Result.ResuleInfo(roleMapper.UpdateInfo(role.getName(),role.getDetail(),role.getId()),"SUCCESS","ERROR");
    }
    //========================foodrecord

    @Override
    public Meta disposeFoodRecord(Integer id,Integer userid) {
        System.out.println(id);
        System.out.println(userid);
        FoodRecord foodRecord = foodRecordMapper.selectFoodRecordById(id);
//        webSocket.sendAllMessage("商家已经完成订单!!");
        webSocket.sendTextMessage(userid.toString(),id.toString());
        return new Meta("SUCCESS");
    }
    @Override
    public Meta confirmDisposeFoodRecord(Integer id) {
        System.out.println(id);
        return Result.ResuleInfo(foodRecordMapper.disposeFoodRecord(id));

    }
}
