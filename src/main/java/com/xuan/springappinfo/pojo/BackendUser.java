package com.xuan.springappinfo.pojo;

import java.util.Date;

/**
 * 功能描述: <br>
 * 〈后台用户表〉
 * @Author Yat-Xuan
 * @Description //TODO ASUS
 * @Date 2018/10/26 18:41
 **/
public class BackendUser {
    private Integer id;

    private String usercode;

    private String userpassword;

    private String username;

    private Date creationdate;

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

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
}