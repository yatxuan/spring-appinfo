package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.pojo.AppInfoS;
import com.xuan.springappinfo.service.AppInfoSService;
import com.xuan.springappinfo.utils.entity.Condition;
import com.xuan.springappinfo.utils.Page;
import com.xuan.springappinfo.utils.Result;
import com.xuan.springappinfo.utils.entity.Storage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/25
 * @Time: 16:04
 */
@RestController
@RequestMapping("/appInfoS")
public class AppInfoSController {

    @Resource
    private AppInfoSService appInfoSService;

    /**
     * @Author YatXuan
     * @Description 多条件查询APP基本信息
     * @Date 15:00 2018/10/29 0029
     * @Param [condition]
     * @return com.xuan.springappinfo.utils.Result
     **/

    @RequestMapping("/getAppInfoS")
    public Result getAppInfoS(Condition condition) {

        Page page = appInfoSService.getAppInfoSCount(condition);
        List<Storage> appInfoS = appInfoSService.getAppInfoS(condition, page);

        return Result.getListAndPage(page, appInfoS);
    }

    /**
     * @Author YatXuan
     * @Description 新增APP信息
     * @Date 15:00 2018/10/29 0029
     * @Param [appInfoS]
     * @return com.xuan.springappinfo.utils.Result
     **/
    @RequestMapping("/saveAppInfo")
    public Result saveAppInfo(AppInfoS appInfoS) {

        return appInfoSService.saveAppInfo(appInfoS);

    }

    /**
     * @Author YatXuan
     * @Description 修改APP信息
     * @Date 15:01 2018/10/29 0029
     * @Param [appInfoS]
     * @return com.xuan.springappinfo.utils.Result
     **/
    @RequestMapping("/updateAppinfoS")
    public Result updateAppinfoS(AppInfoS appInfoS){
        return appInfoSService.updateAppinfoS(appInfoS);
    }


    /**
     * @Author YatXuan
     * @Description 通过id查询APP信息
     * @Date 15:06 2018/10/29 0029
     * @Param [id]
     * @return com.xuan.springappinfo.utils.Result
     **/
    @RequestMapping("/getAppInfoId")
    public Result getAppInfoId(Integer id){
        return appInfoSService.getAppInfoId(id);
    }

    /**
     * @Author YatXuan
     * @Description 查询是否能修改APP的版本号
     * @Date 15:56 2018/10/29 0029
     * @Param
     * @return
     **/
    @RequestMapping("/getAppinfoVersion")
    public Result getAppinfoVersion(Integer id){
        return appInfoSService.getAppinfoVersion(id);
    }

    /**
     * 功能描述: <br>
     * 〈查询是否能修改APP的基本信息〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/27 15:57
     * @Param
     * @return
     **/
    public Result getAppinfo(int id){
        return appInfoSService.getAppinfo(id);
    }

    /**
     * 审核APP
     * @Author YatXuan
     * @Description //TODO
     * @Date 16:45 2018/10/29 0029
     * @Param [appId, statusId]
     * @return com.xuan.springappinfo.utils.Result
     **/

    @RequestMapping("/updateAppStatus")
    public Result updateAppStatus(AppInfoS appInfoS){
        return appInfoSService.updateAppStatus(appInfoS);
    }
}
