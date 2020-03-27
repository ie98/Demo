package com.exmaple.Demo.dto;

public class LoginMeta {
    private String message;
    private Integer status;

    public LoginMeta(String message, Integer status) {
        this.message = message;
        this.status = status;
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
