package com.exmaple.Demo.dto;

import lombok.Data;

@Data
public class AlipayForm {
    private String out_trade_no;
    private String subject;
    private String total_amount;
    private String body;
    private String timeout_express;
    private String product_code;
}
