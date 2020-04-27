package com.exmaple.Demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class TagAndChild {
    private Integer id;
    private Integer pid;
    private Integer level;
    private Boolean deleted;
    private String tagname;
    private List<TagAndChild> children = new ArrayList<>();


}
