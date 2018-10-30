package com.xuan.springappinfo.service;

import com.xuan.springappinfo.pojo.AppVersion;
import com.xuan.springappinfo.utils.Result;

public interface AppVersionService {

    /**
     * 新增APP版本信息
     * @Author YatXuan
     * @Description //TODO
     * @Date 16:26 2018/10/29 0029
     * @Param [appVersion]
     * @return com.xuan.springappinfo.utils.Result
     **/
    Result saveAppVersion(AppVersion appVersion);

    /**
     * 通过APPid查询所有APP版本信息
     * @Author YatXuan
     * @Description //TODO
     * @Date 16:26 2018/10/29 0029
     * @Param
     * @return
     **/
    Result getAppVersionS(int id);
}
