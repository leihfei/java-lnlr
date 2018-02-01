package com.lnlr.demo.utils;

public enum StoreType {
    DB("db"), FILE("file");

    private String value;

    private StoreType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}