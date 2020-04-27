package com.exmaple.Demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ListAndMetaResult {
    private List<Object> list = new ArrayList<>();
    private Meta meta;
}
