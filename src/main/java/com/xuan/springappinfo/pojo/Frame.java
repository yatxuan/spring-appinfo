package com.xuan.springappinfo.pojo;

public class Frame {
    private Integer id;

    private String frametype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrametype() {
        return frametype;
    }

    public void setFrametype(String frametype) {
        this.frametype = frametype == null ? null : frametype.trim();
    }
}