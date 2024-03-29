package com.xuan.springappinfo.utils.entity;

import lombok.Data;

import java.util.Date;

/**
 * <p>Description: 数据存储类 </p>
 * 功能描述: <br>
 * 〈用于保存查询到的数据〉
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/26
 * @Time: 10:29
 */
@Data
public class Storage {

    /**
     * APP软件 id
     */
    private Integer appId;
    /**
     * APP 版本号id
     */
    private Integer appVersionId;
    /**
     * APP 软件名称
     */
    private String softwareName;
    /**
     * APP 的APK名称（唯一）
     */
    private String aPKName;
    /**
     * APP支持的ROM(版本号)
     */
    private String supportROM;
    /**
     * APP 界面语言ID
     */
    private Integer interfaceLanguageId;
    /**
     * APP 语言
     */
    private String language;

    /**
     * APP 软件大小（单位：M）
     */
    private double softwareSize;
    /**
     * APP 版本更新日期
     */
    private Date updateDate;
    /**
     * APP 开发者id
     */
    private Integer devUserId;
    /**
     * APP 开发者名称
     */
    private String devUserName;
    /**
     * APP 应用简介
     */
    private String appIntroduction;
    /**
     * APP 审核状态ID
     */
    private int statusId;
    /**
     * APP 审核状态
     */
    private String statusType;
    /**
     * APP 上架状态ID
     */
    private int frameId;
    /**
     * APP 上架状态
     */
    private String frameType;

    /**
     * APP 上架时间
     */
    private Date onSaleDate;
    /**
     * APP 下架时间
     */
    private Date offSaleDate;
    /**
     * APP 所属平台id
     */
    private int flatformId;
    /**
     * APP 所属平台名称
     */
    private String flatformName;
    /**
     * APP 下载量
     */
    private int downloads;
    /**
     * APP 创建者
     */
    private int createdBy;
    /**
     * APP 创建者名称
     */
    private String createByName;
    /**
     * APP 创建时间
     */
    private Date creationDate;
    /**
     * APP 所属一级分类id
     */
    private int firstAPPClassId;
    /**
     * APP 所属一级分类名称
     */
    private String firstAPPName;
    /**
     * APP 所属二级分类id
     */
    private int twoAPPClassId;
    /**
     * APP 所属二级分类名称
     */
    private String twoAPPName;
    /**
     * APP 所属三级分类id
     */
    private int threeAPPClassId;
    /**
     * APP 所属三级分类名称
     */
    private String threeAPPName;
    /**
     * APP LOGO图片url路径
     */
    private String logoPicPath;
    /**
     * APP LOGO图片的服务器存储路径
     */
    private String logoLocPath;
    /**
     * APP 最新的版本id
     */
    private Integer versionId;
    /**
     * APP 版本编号
     */
    private String versionNo;

    /**
     * APP 版本大小
     */
    private double versionSize;

    /**
     * APP 版本发布状态
     */
    private String releaseStatusName;

    /**
     * APP版本的APK名称
     */
    private String apkFileName;

    /**
     * APP 版本的最近更新时间
     */
    private Date modifyDate;

    /**
     * APP 版本下载路径
     */
    private String apkLocPath;

}
