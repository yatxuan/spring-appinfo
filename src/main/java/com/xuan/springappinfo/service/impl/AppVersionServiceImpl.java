package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.AppVersionMapper;
import com.xuan.springappinfo.pojo.AppVersion;
import com.xuan.springappinfo.service.AppVersionService;
import com.xuan.springappinfo.utils.Result;
import com.xuan.springappinfo.utils.entity.Storage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Author:   YatXuan
 * Date:     2018/10/29 0029 16:32
 **/
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {

    @Resource
    private AppVersionMapper appVersionMapper;

    @Override
    public Result saveAppVersion(AppVersion appVersion) {
        appVersion.setModifydate(new Date());
        int appVuersion = appVersionMapper.insertSelective(appVersion);

        if (appVuersion > 0) {

            return Result.getSuccess();
        }
        return Result.getError();
    }

    @Override
    public Result getAppVersionS(int appId) {
        List<Storage> storageList = appVersionMapper.getAppVersionS(appId);
        return Result.getList(storageList);
    }

    @Override
    public Result getAppVersionId(Integer appVersionId) {
        AppVersion appVersion = appVersionMapper.getAppVersionId(appVersionId);
        return Result.getClass(appVersion);
    }
}
