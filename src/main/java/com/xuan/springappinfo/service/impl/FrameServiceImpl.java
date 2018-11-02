package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.FrameMapper;
import com.xuan.springappinfo.pojo.Frame;
import com.xuan.springappinfo.service.FrameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/11/2 0002
 * @Time: 15:22
 */
@Service("frameService")
public class FrameServiceImpl implements FrameService {

    @Resource
    private FrameMapper frameMapper;

    @Override
    public List<Frame> getFrame() {
        return frameMapper.getFrame();
    }
}
