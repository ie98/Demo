package com.exmaple.Demo.service;

import com.exmaple.Demo.model.Chair;
import com.exmaple.Demo.model.DiningTable;

import java.util.List;

public interface SitSelectService {
    public List<DiningTable> selectAllChair(String Table);
    public Chair selectOne();
//    public void selectAllTable();
}
