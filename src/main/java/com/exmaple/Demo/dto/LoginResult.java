package com.exmaple.Demo.dto;

import com.exmaple.Demo.constant.ResultCode;

public class LoginResult {
    private String Token;
    private LoginMeta meta;

    public LoginMeta getMeta() {
        return meta;
    }

    public void setMeta(LoginMeta meta) {
        this.meta = meta;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
