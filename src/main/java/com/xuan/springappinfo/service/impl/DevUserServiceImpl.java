package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.DevUserMapper;
import com.xuan.springappinfo.pojo.DevUser;
import com.xuan.springappinfo.service.DevUserService;
import com.xuan.springappinfo.utils.Result;
import com.xuan.springappinfo.utils.redis.RedisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:   YatXuan
 * Date:     2018/10/29 0029 16:40
 **/
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {

    @Resource
    private DevUserMapper devUserMapper;
    @Resource
    private RedisService redisService;

    /**
     * 储存在redis里的key
     */
    private final static String REDISKEY = "devUserList";

    @Override
    public Result getDevUsers() {

        List<DevUser> devUserList;

        if (redisService.exists(REDISKEY)) {
            devUserList = redisService.getList(REDISKEY);
        } else {
            devUserList = devUserMapper.getDevUsers();
            redisService.setList(REDISKEY, devUserList);
        }

        return Result.getClass(devUserList);
    }
}
