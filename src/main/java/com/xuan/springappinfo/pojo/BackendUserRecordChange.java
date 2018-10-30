package com.xuan.springappinfo.pojo;

import java.util.Date;

public class BackendUserRecordChange {
    private Integer id;

    private Integer backenduserid;

    private Integer modifyby;

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

    public Integer getModifyby() {
        return modifyby;
    }

    public void setModifyby(Integer modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
}