package com.exmaple.Demo.dto;

import java.util.Date;

public class chair {
    private int chairNumber;
    private int inTable;
    private Boolean empty;
    private Date sitTime;

    public int getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(int chairNumber) {
        this.chairNumber = chairNumber;
    }

    public int getInTable() {
        return inTable;
    }

    public void setInTable(int inTable) {
        this.inTable = inTable;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public Date getSitTime() {
        return sitTime;
    }

    public void setSitTime(Date sitTime) {
        this.sitTime = sitTime;
    }
}
