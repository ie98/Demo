package com.exmaple.Demo.dto;

import com.exmaple.Demo.model.DiningTable;

import java.util.List;

public class TablesAndMeta {
    List<DiningTable> tables;
    private Meta meta;

    public TablesAndMeta(List<DiningTable> tables, Meta meta) {
        this.tables = tables;
        this.meta = meta;
    }

    public List<DiningTable> getTables() {
        return tables;
    }


    public void setTables(List<DiningTable> tables) {
        this.tables = tables;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
