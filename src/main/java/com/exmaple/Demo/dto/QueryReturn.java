package com.exmaple.Demo.dto;
import  com.exmaple.Demo.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Data
public class QueryReturn {
    private List<Object> list = new ArrayList<>();
    private int num;
}
