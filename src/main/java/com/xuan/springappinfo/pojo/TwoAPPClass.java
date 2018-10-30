package com.xuan.springappinfo.pojo;

public class TwoAPPClass {
    private Integer id;

    private String twoappname;

    private Integer firstappclassid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTwoappname() {
        return twoappname;
    }

    public void setTwoappname(String twoappname) {
        this.twoappname = twoappname == null ? null : twoappname.trim();
    }

    public Integer getFirstappclassid() {
        return firstappclassid;
    }

    public void setFirstappclassid(Integer firstappclassid) {
        this.firstappclassid = firstappclassid;
    }
}