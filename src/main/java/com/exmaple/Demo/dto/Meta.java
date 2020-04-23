package com.exmaple.Demo.dto;

import com.exmaple.Demo.constant.ResultCode;

public class Meta {
    private String message;
    private Integer status;

    public Meta(String info) {
        this.message = ResultCode.getMessage(info);
        this.status = ResultCode.getCode(info);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
