package com.exmaple.Demo.util;

import com.exmaple.Demo.dto.Meta;

public class Result {
    public static Meta ResuleInfo(Boolean bool, String SUCCESS , String ERROR){
        return bool == true ? new Meta(SUCCESS):new Meta(ERROR);
    }
    public static Meta ResuleInfo(Boolean bool){
        return bool == true ? new Meta("SUCCESS"):new Meta("ERROR");
    }
}
