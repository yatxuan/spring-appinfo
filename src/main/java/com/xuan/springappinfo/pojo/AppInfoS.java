package com.xuan.springappinfo.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 功能描述: <br>
 * 〈APP基本信息表〉
 *
 * @Author Yat-Xuan
 * @Description //TODO ASUS
 * @Date 2018/10/25 16:03
 **/
@Data
public class AppInfoS {
    private Integer id;

    private String softwarename;

    private String apkname;

    private String supportrom;

    private Integer interfacelanguageid;

    private Double softwaresize;

    private Date updatedate;

    private Integer devuserid;

    private String appintroduction;

    private Integer statusid;

    private Integer frameid;

    private Date onsaledate;

    private Date offsaledate;

    private Integer flatformid;

    private Double downloads;

    private Integer createdby;

    private Date creationdate;

    private Integer firstappclassid;

    private Integer twoappclassid;

    private Integer threeappclassid;

    private String logopicpath;

    private String logolocpath;

    private Integer versionid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename == null ? null : softwarename.trim();
    }

    public String getApkname() {
        return apkname;
    }

    public void setApkname(String apkname) {
        this.apkname = apkname == null ? null : apkname.trim();
    }

    public String getSupportrom() {
        return supportrom;
    }

    public void setSupportrom(String supportrom) {
        this.supportrom = supportrom == null ? null : supportrom.trim();
    }

    public Integer getInterfacelanguageid() {
        return interfacelanguageid;
    }

    public void setInterfacelanguageid(Integer interfacelanguageid) {
        this.interfacelanguageid = interfacelanguageid;
    }

    public Double getSoftwaresize() {
        return softwaresize;
    }

    public void setSoftwaresize(Double softwaresize) {
        this.softwaresize = softwaresize;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Integer getDevuserid() {
        return devuserid;
    }

    public void setDevuserid(Integer devuserid) {
        this.devuserid = devuserid;
    }

    public String getAppintroduction() {
        return appintroduction;
    }

    public void setAppintroduction(String appintroduction) {
        this.appintroduction = appintroduction == null ? null : appintroduction.trim();
    }

    public Integer getStatusid() {
        return statusid;
    }

    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    public Integer getFrameid() {
        return frameid;
    }

    public void setFrameid(Integer frameid) {
        this.frameid = frameid;
    }

    public Date getOnsaledate() {
        return onsaledate;
    }

    public void setOnsaledate(Date onsaledate) {
        this.onsaledate = onsaledate;
    }

    public Date getOffsaledate() {
        return offsaledate;
    }

    public void setOffsaledate(Date offsaledate) {
        this.offsaledate = offsaledate;
    }

    public Integer getFlatformid() {
        return flatformid;
    }

    public void setFlatformid(Integer flatformid) {
        this.flatformid = flatformid;
    }

    public Double getDownloads() {
        return downloads;
    }

    public void setDownloads(Double downloads) {
        this.downloads = downloads;
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

    public Integer getFirstappclassid() {
        return firstappclassid;
    }

    public void setFirstappclassid(Integer firstappclassid) {
        this.firstappclassid = firstappclassid;
    }

    public Integer getTwoappclassid() {
        return twoappclassid;
    }

    public void setTwoappclassid(Integer twoappclassid) {
        this.twoappclassid = twoappclassid;
    }

    public Integer getThreeappclassid() {
        return threeappclassid;
    }

    public void setThreeappclassid(Integer threeappclassid) {
        this.threeappclassid = threeappclassid;
    }

    public String getLogopicpath() {
        return logopicpath;
    }

    public void setLogopicpath(String logopicpath) {
        this.logopicpath = logopicpath == null ? null : logopicpath.trim();
    }

    public String getLogolocpath() {
        return logolocpath;
    }

    public void setLogolocpath(String logolocpath) {
        this.logolocpath = logolocpath == null ? null : logolocpath.trim();
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }
}