package com.exmaple.Demo.dto;

import com.exmaple.Demo.model.Role;

public class RII {
    private Role role;
    private int fatherId;
    private int sonId;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getFatherId() {
        return fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }

    public int getSonId() {
        return sonId;
    }

    public void setSonId(int sonId) {
        this.sonId = sonId;
    }
}
