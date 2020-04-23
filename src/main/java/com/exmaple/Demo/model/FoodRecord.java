package com.exmaple.Demo.model;

import lombok.Data;

@Data
public class FoodRecord {
    private String out_trade_no;
    private String subject;
    private String total_amount;
    private String body;
    private String timeout_express;
    private String product_code;
}
