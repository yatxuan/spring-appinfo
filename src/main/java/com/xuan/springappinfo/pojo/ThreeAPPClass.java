package com.xuan.springappinfo.pojo;

public class ThreeAPPClass {
    private Integer id;

    private String threeappname;

    private Integer twoappclassid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThreeappname() {
        return threeappname;
    }

    public void setThreeappname(String threeappname) {
        this.threeappname = threeappname == null ? null : threeappname.trim();
    }

    public Integer getTwoappclassid() {
        return twoappclassid;
    }

    public void setTwoappclassid(Integer twoappclassid) {
        this.twoappclassid = twoappclassid;
    }
}