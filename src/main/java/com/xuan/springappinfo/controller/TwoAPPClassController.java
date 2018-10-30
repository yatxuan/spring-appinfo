package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.pojo.TwoAPPClass;
import com.xuan.springappinfo.service.TwoAPPClassService;
import com.xuan.springappinfo.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 16:40
 */
@RestController
@RequestMapping("/twoAPPClass")
public class TwoAPPClassController {

    @Resource
    private TwoAPPClassService twoAPPClassService;

    @RequestMapping("/getTwoAPPClass")
    public Result getTwoAPPClass(int firstAPPClassId) {
        List<TwoAPPClass> twoAPPClassList = twoAPPClassService.getTwoAPPClass(firstAPPClassId);
        return Result.getList(twoAPPClassList);

    }
}
