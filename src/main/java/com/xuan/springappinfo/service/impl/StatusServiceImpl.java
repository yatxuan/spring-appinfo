package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.StatusMapper;
import com.xuan.springappinfo.pojo.Status;
import com.xuan.springappinfo.service.StatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/11/2 0002
 * @Time: 9:25
 */
@Service("statusService")
public class StatusServiceImpl implements StatusService {

    @Resource
    private StatusMapper statusMapper;

    @Override
    public List<Status> getStatus() {
        return statusMapper.getStatus();
    }
}
