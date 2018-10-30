package com.xuan.springappinfo.pojo;

public class RolesRelation {
    private Integer id;

    private String usercode;

    private String rolesid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getRolesid() {
        return rolesid;
    }

    public void setRolesid(String rolesid) {
        this.rolesid = rolesid == null ? null : rolesid.trim();
    }
}