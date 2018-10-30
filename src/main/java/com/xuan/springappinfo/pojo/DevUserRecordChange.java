package com.xuan.springappinfo.pojo;

import java.util.Date;

public class DevUserRecordChange {
    private Integer id;

    private Integer backenduserid;

    private String modifyby;

    private Date modifydate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBackenduserid() {
        return backenduserid;
    }

    public void setBackenduserid(Integer backenduserid) {
        this.backenduserid = backenduserid;
    }

    public String getModifyby() {
        return modifyby;
    }

    public void setModifyby(String modifyby) {
        this.modifyby = modifyby == null ? null : modifyby.trim();
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
}