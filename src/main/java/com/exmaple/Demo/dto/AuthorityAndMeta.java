package com.exmaple.Demo.dto;

import com.exmaple.Demo.model.Authority;

import java.util.List;

public class AuthorityAndMeta {
    private List<Authority> authorities;
    private Meta meta;

    public AuthorityAndMeta(List<Authority> authorities, Meta meta) {
        this.authorities = authorities;
        this.meta = meta;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
