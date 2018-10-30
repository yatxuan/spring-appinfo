package com.xuan.springappinfo.pojo;

/**
 * 功能描述: <br>
 * 〈一级分类〉
 * @Author Yat-Xuan
 * @Description //TODO ASUS
 * @Date 2018/10/24 16:40
 **/
public class FirstAPPClass {
    private Integer id;

    private String firstappname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstappname() {
        return firstappname;
    }

    public void setFirstappname(String firstappname) {
        this.firstappname = firstappname == null ? null : firstappname.trim();
    }
}