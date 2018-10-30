package com.xuan.springappinfo.service;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import com.xuan.springappinfo.pojo.AppInfoS;
import com.xuan.springappinfo.pojo.AppVersion;
import com.xuan.springappinfo.utils.Result;
import com.xuan.springappinfo.utils.entity.Condition;
import com.xuan.springappinfo.utils.Page;
import com.xuan.springappinfo.utils.entity.Storage;

import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/25
 * @Time: 16:04
 */
public interface AppInfoSService {

    /**
     * 功能描述: <br>
     * 〈查询所有App的信息〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/25 16:51
     * @Param [condition, page]条件工具类 分页工具类
     * @return java.util.List<com.xuan.springappinfo.pojo.AppInfoS>
     **/
    List<Storage> getAppInfoS(Condition condition, Page page);

    /**
     * 功能描述: <br>
     * 〈查询总数据量〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/25 16:50
     * @Param [condition] 条件工具类
     * @return com.xuan.springappinfo.utils.Page 分页工具类储存
     **/
    Page getAppInfoSCount(Condition condition);

    /**
     * 功能描述: <br>
     * 〈添加APP信息〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/27 15:48
     * @Param [appinfoS]
     * @return Result
     **/
    Result saveAppInfo(AppInfoS appInfoS);

    /**
     * 功能描述: <br>
     * 〈修改APP基本信息〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/27 15:55
     * @Param [appInfoS]
     * @return com.xuan.springappinfo.utils.Result
     **/
    Result updateAppinfoS(AppInfoS appInfoS);

    /**
     * @Author YatXuan
     * @Description 通过id查询APP信息
     * @Date 15:06 2018/10/29 0029
     * @Param [id]
     * @return com.xuan.springappinfo.utils.Result
     **/
    Result getAppInfoId(Integer id);

    /**
     * 功能描述: <br>
     * 〈查询是否能修改APP的版本号〉
     * @Author YatXuan
     * @Description
     * @Date 15:58 2018/10/29 0029
     * @Param [id]
     * @return com.xuan.springappinfo.utils.Result
     **/
    Result getAppinfoVersion(Integer id);

    /**
     * 功能描述: <br>
     * 〈查询是否能修改APP的基本信息〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/27 15:57
     * @Param
     * @return
     **/
    Result getAppinfo(int id);

    /**
     * 审核APP信息
     * @Author YatXuan
     * @Description //TODO
     * @Date 16:46 2018/10/29 0029
     * @Param [appId, statusId]
     * @return com.xuan.springappinfo.utils.Result
     **/

    Result updateAppStatus(AppInfoS appInfoS);

    /**
     * 功能描述: <br>
     * 〈查询是否能修改APP的版本号〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/27 15:57
     * @Param
     * @return 
     **/
}
