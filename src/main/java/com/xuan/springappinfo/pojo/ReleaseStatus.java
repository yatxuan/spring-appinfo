package com.xuan.springappinfo.pojo;

public class ReleaseStatus {
    private Integer id;

    private String releasestatusname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReleasestatusname() {
        return releasestatusname;
    }

    public void setReleasestatusname(String releasestatusname) {
        this.releasestatusname = releasestatusname == null ? null : releasestatusname.trim();
    }
}