package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.pojo.InterfaceLanguage;
import com.xuan.springappinfo.service.InterfaceLanguageService;
import com.xuan.springappinfo.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 查询所有语言 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/11/2 0002
 * @Time: 23:37
 */
@RestController
@RequestMapping("/interfaceLanguage")
public class InterfaceLanguageController {

    @Resource
    private InterfaceLanguageService interfaceLanguageService;

    @RequestMapping("/getInterfaceLanguageS")
    public Result getInterfaceLanguageS() {
        List<InterfaceLanguage> interfaceLanguageS = interfaceLanguageService.getInterfaceLanguageS();
        return Result.getList(interfaceLanguageS);
    }
}
