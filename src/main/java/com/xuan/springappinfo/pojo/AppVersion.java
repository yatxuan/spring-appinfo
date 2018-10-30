package com.xuan.springappinfo.pojo;

import java.util.Date;

public class AppVersion {
    private Integer id;

    private Integer appinfoid;

    private String versionno;

    private String versioninfo;

    private Integer releasestatusid;

    private String downloadlink;

    private Double versionsize;

    private Integer modifyby;

    private Date modifydate;

    private String apklocpath;

    private String apkfilename;

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

    public String getVersionno() {
        return versionno;
    }

    public void setVersionno(String versionno) {
        this.versionno = versionno == null ? null : versionno.trim();
    }

    public String getVersioninfo() {
        return versioninfo;
    }

    public void setVersioninfo(String versioninfo) {
        this.versioninfo = versioninfo == null ? null : versioninfo.trim();
    }

    public Integer getReleasestatusid() {
        return releasestatusid;
    }

    public void setReleasestatusid(Integer releasestatusid) {
        this.releasestatusid = releasestatusid;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink == null ? null : downloadlink.trim();
    }

    public Double getVersionsize() {
        return versionsize;
    }

    public void setVersionsize(Double versionsize) {
        this.versionsize = versionsize;
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

    public String getApklocpath() {
        return apklocpath;
    }

    public void setApklocpath(String apklocpath) {
        this.apklocpath = apklocpath == null ? null : apklocpath.trim();
    }

    public String getApkfilename() {
        return apkfilename;
    }

    public void setApkfilename(String apkfilename) {
        this.apkfilename = apkfilename == null ? null : apkfilename.trim();
    }
}