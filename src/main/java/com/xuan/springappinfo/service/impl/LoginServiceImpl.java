package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.LoginMapper;
import com.xuan.springappinfo.service.LoginService;
import com.xuan.springappinfo.utils.entity.User;
import com.xuan.springappinfo.utils.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 13:57
 */
@Service("loginService")
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Resource
    private RedisService redisService;

    @Override
    public String getUser(String userCode) {

        log.info("通过账号:" + userCode + "查询密码");
        User user;

        //判断该账号存是否在redis里，在的话就直接取出redis里的数据
        if (redisService.exists(userCode)) {
            log.info("从redis取出账号"+userCode+"的数据");
            return redisService.getClazz(userCode, User.class).getPassWord();
        } else {
            log.info("从管理者表查询数据");
            user = loginMapper.getBackendUser(userCode);

            if (user != null) {
                log.info("账号"+userCode+"添加管理者身份");
                user.setRoles("管理者");
            } else {
                log.info("从开发者表查询");
                user = loginMapper.getDevUser(userCode);

                if (user != null) {
                    log.info("账号"+userCode+"添加开发者身份");
                    user.setRoles("开发者");
                } else {
                    log.info("没有查询到数据");
                    return null;
                }
            }

            log.info("查询到数据，保存到redis中去");
            redisService.setClass(userCode, user);
            return user.getPassWord();
        }
    }

    @Override
    public List<String> getRoles(String userCode) {
        return loginMapper.getRoles(userCode);
    }

    @Override
    public List<String> getPermissions(String userCode) {
        return loginMapper.getPermissions(userCode);
    }
}
