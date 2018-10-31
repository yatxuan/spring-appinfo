package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.utils.Result;
import com.xuan.springappinfo.utils.entity.User;
import com.xuan.springappinfo.utils.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: YatXuan
 * @Date: 2018/10/31 0031 14:59
 **/
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Resource
    private RedisService redisService;

    @RequestMapping("/getuser")
    public Result getUser(User user) {

        log.info("进入登录方法！");

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getCode(), user.getPassWord());

        subject.login(token);

//       退出登录方法之前，再从redis取出刚刚查询到的数据，返回登录账号的信息！
        if (redisService.exists(user.getCode())) {
            user = redisService.getClazz(user.getCode(), User.class);
            user.setPassWord(null);

            //返回数据之前，先清空该账号密码,在把该账号保存到session里
            subject.getSession().setAttribute("user", user);

            log.info("退出登录方法！");
            return Result.getClass(user);
        }
        return Result.getFailure();

    }
}
