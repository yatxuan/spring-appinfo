package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.pojo.FirstAPPClass;
import com.xuan.springappinfo.service.FirstAPPClassService;
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
 * @Date: 2018/10/24
 * @Time: 16:38
 */
@RestController
@RequestMapping("/firstAPPClass")
public class FirstAPPClassController {

    @Resource
    private FirstAPPClassService firstAPPClassService;

    @RequestMapping("/getFirstAPPClass")
    public Result getFirstAPPClass() {
        List<FirstAPPClass> firstAPPClassList = firstAPPClassService.getFirstAPPClass();
        return Result.getList(firstAPPClassList);
    }
}
