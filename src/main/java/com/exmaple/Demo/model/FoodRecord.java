package com.exmaple.Demo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class FoodRecord {
    private Integer id;
    private String out_trade_no;
    private String subject;
    private String total_amount;
    private String body;
    private String timeout_express;
    private String product_code;
    private String username;
    private Date date;
    private String remarks;
    private Integer star;
    private String labels;
    private Integer userid;
    private List<Long> dates = new ArrayList<>();
    private Integer allneedtime;
    private Boolean dispose;
}
