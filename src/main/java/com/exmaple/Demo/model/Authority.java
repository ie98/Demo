package com.exmaple.Demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Authority {
    private  int id;
    private String authorityname;
    private int authorityid;
    private int fatherid;
    private String path;
    private int autograde;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority = (Authority) o;
        return id == authority.id &&
                authorityid == authority.authorityid &&
                fatherid == authority.fatherid &&
                autograde == authority.autograde &&
                Objects.equals(authorityname, authority.authorityname) &&
                Objects.equals(path, authority.path) &&
                Objects.equals(son, authority.son);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorityname, authorityid, fatherid, path, autograde, son);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getAutograde() {
        return autograde;
    }

    public void setAutograde(int autograde) {
        this.autograde = autograde;
    }

    private List<Authority> son = new ArrayList<>();

    public List<Authority> getSon() {
        return son;
    }

    public void setSon(List<Authority> son) {
        this.son = son;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorityname() {
        return authorityname;
    }

    public void setAuthorityname(String authorityname) {
        this.authorityname = authorityname;
    }

    public int getAuthorityid() {
        return authorityid;
    }

    public void setAuthorityid(int authorityid) {
        this.authorityid = authorityid;
    }

    public int getFatherid() {
        return fatherid;
    }

    public void setFatherid(int fatherid) {
        this.fatherid = fatherid;
    }
}
