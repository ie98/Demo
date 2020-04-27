package com.exmaple.Demo.model;

import lombok.Data;

@Data
public class Tag {
    private Integer id;
    private Integer pid;
    private Integer level;
    private Boolean deleted;
    private String tagname;
}
