package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.pojo.ThreeAPPClass;
import com.xuan.springappinfo.service.ThreeAPPClassService;
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
 * @Time: 16:47
 */
@RestController
@RequestMapping("/threeAPPClass")
public class ThreeAPPClassController {

    @Resource
    private ThreeAPPClassService threeAPPClassService;

    /**
     * 功能描述: <br>
     * 〈通过二级分类id，获取对应的三级分类的数据〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 19:02
     * @Param [twoAPPClassId]
     * @return com.xuan.springappinfo.utils.Result
     **/
    @RequestMapping("/getThreeAPPClass")
    public Result getThreeAPPClass(int twoAPPClassId) {
        List<ThreeAPPClass> threeAPPClassList = threeAPPClassService.getThreeAPPClass(twoAPPClassId);
        return Result.getList(threeAPPClassList);
    }
}
