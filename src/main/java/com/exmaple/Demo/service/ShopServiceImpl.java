package com.exmaple.Demo.service;

import com.exmaple.Demo.mapper.ShopMapper;
import com.exmaple.Demo.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Override
    public List<Shop> selectAllShop() {
        return shopMapper.selectAllShop();
    }
}
