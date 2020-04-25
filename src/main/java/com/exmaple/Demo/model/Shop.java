package com.exmaple.Demo.model;

import lombok.Data;

@Data
public class Shop {
    private Integer id;
    private Integer shopid;
    private String shopname;
    private boolean forbid;
    private String described;
    private String notice;
    private String principal;
    private String phone;
    private Integer sales;
    private String logo;
}
