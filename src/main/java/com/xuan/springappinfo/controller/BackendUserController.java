package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.pojo.BackendUser;
import com.xuan.springappinfo.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;


/**
 * 功能描述: <br>
 * 〈后台管理者用户〉
 *
 * @Author Yat-Xuan
 * @Description //TODO ASUS
 * @Date 2018/10/24 10:53
 **/
@RestController
@RequestMapping("/backendUser")
public class BackendUserController {


    @RequestMapping("/getBackendUser")
    public Result getBackendUser(BackendUser backendUser) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(backendUser.getUsercode(), backendUser.getUserpassword());

        subject.login(token);
        subject.getSession().setAttribute("user",backendUser);

        return Result.getSuccess();

    }

}