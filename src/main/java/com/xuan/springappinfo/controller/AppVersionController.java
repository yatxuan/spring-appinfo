package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.pojo.AppVersion;
import com.xuan.springappinfo.service.AppVersionService;
import com.xuan.springappinfo.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * App版本信息类
 *
 * @Author: YatXuan
 * Date:     2018/10/29 0029 16:24
 */
@RestController
@RequestMapping("/appVersion")
public class AppVersionController {

    @Resource
    private AppVersionService appVersionService;

    /**
     * <p>Description: 新增APP版本信息 </p>
     * @author Yat-Xuan
     * @params: [appVersion]
     * @return: com.xuan.springappinfo.utils.Result
     * @Date: 2018/11/5 0005 13:52
     * @Modified By:
    */
    @RequestMapping("/saveAppVersion")
    public Result saveAppVersion(AppVersion appVersion) {
        return appVersionService.saveAppVersion(appVersion);
    }

    /**通过APP的id查询它所有的版本信息
     * @Author YatXuan
     * @Description //TODO
     * @Date 14:07 2018/10/31 0031
     * @Param [appId]
     * @return com.xuan.springappinfo.utils.Result
     **/
    @RequestMapping("/getAppVersionS")
    public Result getAppVersionS(Integer appId) {
        return appVersionService.getAppVersionS(appId);
    }

    /**通过APP的版本id查询它的信息
     * @Author YatXuan
     * @Description //TODO
     * @Date 14:07 2018/10/31 0031
     * @Param [appVersionId] APP版本号id
     * @return com.xuan.springappinfo.utils.Result
     **/
    @RequestMapping("/getAppVersionId")
    public Result getAppVersionId(Integer appVersionId) {
        return appVersionService.getAppVersionId(appVersionId);
    }
}
