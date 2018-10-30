package com.xuan.springappinfo.utils.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Description: 条件类 </p>
 * 功能描述: <br>
 * 〈用于保存查询的条件〉
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/25
 * @Time: 16:15
 */
@Getter
@Setter
public class Condition {
    /**
     * App软件ID
     */
    private Integer appId;

    /**
     * APP软件名称
     */
    private String softwareName;

    /**
     * APP所属平台id
     */
    private Integer flatFormId;

    /**
     * App一级分类ID
     */
    private Integer firstAPPClassId;

    /**
     * App二级分类ID
     */
    private Integer twoAPPClassId;

    /**
     * App三级分类ID
     */
    private Integer threeAPPClassId;

    /**
     * 当前页码
     */
    private Integer currNo=1;

    /**
     * 每页显示数据量
     */
    private Integer size=15;

    /**
     * APP 上架状态ID
     */
    private int frameId;

    /**
     * APP 审核状态ID
     */
    private int statusId;

    /**
     * APP 开发者id
     */
    private int devUserId;

}
