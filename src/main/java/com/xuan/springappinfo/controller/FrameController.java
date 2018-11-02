package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.pojo.Frame;
import com.xuan.springappinfo.service.FrameService;
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
 * @Time: 15:21
 */
@RestController
@RequestMapping("/frame")
public class FrameController {

    @Resource
    private FrameService frameService;

    @RequestMapping("/getFrame")
    public Result getFrame() {
        List<Frame> frameList = frameService.getFrame();
        return Result.getList(frameList);
    }
}
