package com.exmaple.Demo.dto;

public class IdAndName {
    private int sitId;
    private String name;

    @Override
    public String toString() {
        return "{" +
                "sitId=" + sitId +
                ", name='" + name + '\'' +
                '}';
    }

    public int getSitId() {
        return sitId;
    }

    public void setSitId(int sitId) {
        this.sitId = sitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
