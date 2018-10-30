package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.service.DevUserService;
import com.xuan.springappinfo.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author:   YatXuan
 * Date:     2018/10/29 0029 16:38
 **/
@RestController
@RequestMapping("/devUser")
public class devUserController {

    @Resource
    private DevUserService devUserService;

    @RequestMapping("/getDevUsers")
    public Result getDevUsers() {
        return devUserService.getDevUsers();
    }
}
