package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.AppVersionMapper;
import com.xuan.springappinfo.pojo.AppVersion;
import com.xuan.springappinfo.service.AppVersionService;
import com.xuan.springappinfo.utils.Result;
import com.xuan.springappinfo.utils.redis.RedisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:   YatXuan
 * Date:     2018/10/29 0029 16:32
 **/
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {

    @Resource
    private AppVersionMapper appVersionMapper;
    @Resource
    private RedisService redisService;

    /**
     * 储存在redis里的key
     */
    private final static String REDISKEY = "appVersionList";
    private List<AppVersion> appVersionList = new ArrayList<>();

    @Override
    public Result saveAppVersion(AppVersion appVersion) {
        int appVuersion = appVersionMapper.insertSelective(appVersion);

        if (appVuersion > 0) {

            if (redisService.exists(REDISKEY)) {
                appVersionList = redisService.getList(REDISKEY);
                appVersionList.add(appVersion);
            }
            redisService.setList(REDISKEY, appVersionList);

            return Result.getSuccess();
        }
        return Result.getError();
    }

    @Override
    public Result getAppVersionS(int id) {

        if (redisService.exists(REDISKEY)) {
            appVersionList = redisService.getList(REDISKEY);
        } else {
            appVersionList = appVersionMapper.getAppVersionS(id);
            redisService.setList(REDISKEY, appVersionList);
        }

        return Result.getList(appVersionList);
    }
}
