package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.LoginMapper;
import com.xuan.springappinfo.service.LoginService;
import com.xuan.springappinfo.utils.redis.RedisService;
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
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Resource
    private RedisService redisService;

    @Override
    public String getBackendUser(String userCode) {
        String passWord;

        if (redisService.exists(userCode)) {
            return (String) redisService.get(userCode);
        }

        passWord = loginMapper.getBackendUser(userCode);
        redisService.set(userCode, passWord);

        return passWord;
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
