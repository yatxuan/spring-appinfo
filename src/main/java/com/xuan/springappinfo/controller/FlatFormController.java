package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.pojo.FlatForm;
import com.xuan.springappinfo.service.FlatFormService;
import com.xuan.springappinfo.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: APP所属平台类 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 16:11
 */
@RestController
@RequestMapping("/flatForm")
public class FlatFormController {

    @Resource
    private FlatFormService flatFormService;


    @RequestMapping("/getFlatForm")
    public Result getFlatForm() {
        List<FlatForm> flatFormList = flatFormService.getFlatForm();

        return Result.getList(flatFormList);
    }

}
