package com.exmaple.Demo.service;

import com.exmaple.Demo.mapper.ChairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChairControllerServiceImpl implements ChairAbsControllerService {
    @Autowired
    private ChairMapper chairMapper;
    @Override
    public Boolean ChairController(int[] arr , String location) {
        if ("left".equals(location)){
            for (int i = 0; i < arr.length; i++) {
                chairMapper.setEmptyOnChair1(arr[i]);
            }
            return true;
        }

        else if ("right".equals(location)){
            for (int i = 0; i < arr.length; i++) {
                chairMapper.setEmptyOnChair2(arr[i]);
            }
            return true;
        }

        return false;
    }
}
