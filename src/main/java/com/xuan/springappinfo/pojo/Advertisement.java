package com.xuan.springappinfo.pojo;

import java.util.Date;

public class Advertisement {
    private Integer id;

    private Integer appinfoid;

    private String adpicpath;

    private Double adpv;

    private Double carouselposition;

    private Date starttime;

    private Date endtime;

    private Integer createdby;

    private Date creationdate;

    private Integer modifyby;

    private Date modifydate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppinfoid() {
        return appinfoid;
    }

    public void setAppinfoid(Integer appinfoid) {
        this.appinfoid = appinfoid;
    }

    public String getAdpicpath() {
        return adpicpath;
    }

    public void setAdpicpath(String adpicpath) {
        this.adpicpath = adpicpath == null ? null : adpicpath.trim();
    }

    public Double getAdpv() {
        return adpv;
    }

    public void setAdpv(Double adpv) {
        this.adpv = adpv;
    }

    public Double getCarouselposition() {
        return carouselposition;
    }

    public void setCarouselposition(Double carouselposition) {
        this.carouselposition = carouselposition;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
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