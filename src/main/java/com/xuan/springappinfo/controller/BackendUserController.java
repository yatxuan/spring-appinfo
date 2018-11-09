package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
@Slf4j
public class BackendUserController {

   @RequestMapping("/selBackendUserA")
    public Result selBackendUserA(){
       return Result.getCustomize(true,0,"/backend/BackendUserList.html");
   }

}
