package com.xuan.springappinfo.pojo;

public class Status {
    private Integer id;

    private String statustype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatustype() {
        return statustype;
    }

    public void setStatustype(String statustype) {
        this.statustype = statustype == null ? null : statustype.trim();
    }
}