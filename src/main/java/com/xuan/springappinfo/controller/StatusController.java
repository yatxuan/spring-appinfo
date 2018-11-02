package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.pojo.Status;
import com.xuan.springappinfo.service.StatusService;
import com.xuan.springappinfo.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/11/2 0002
 * @Time: 9:23
 */
@RestController
@RequestMapping("/status")
public class StatusController {

    @Resource
    private StatusService statusService;

    @RequestMapping("/getStatus")
    public Result getStatus() {
        List<Status> status = statusService.getStatus();
        return Result.getList(status);
    }
}
