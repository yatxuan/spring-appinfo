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

    @RequestMapping("/saveAppVersion")
    public Result saveAppVersion(AppVersion appVersion) {
        return appVersionService.saveAppVersion(appVersion);
    }

    @RequestMapping("/getAppVersionS")
    public Result getAppVersionS(int id) {
        return appVersionService.getAppVersionS(id);
    }

}
