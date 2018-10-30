package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.FlatFormMapper;
import com.xuan.springappinfo.pojo.FlatForm;
import com.xuan.springappinfo.service.FlatFormService;
import com.xuan.springappinfo.utils.redis.RedisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 15:56
 */
@Service("flatFormService")
public class FlatFormServiceImpl implements FlatFormService {

    @Resource
    private FlatFormMapper flatFormMapper;
    @Resource
    private RedisService redisService;

    /**
     * 储存在redis里的key
     */
    private final String name = "flatFormList";

    @Override
    public List<FlatForm> getFlatForm() {
        List<FlatForm> flatFormList;

        if (redisService.exists(name)) {
            return redisService.getList(name);
        }

        flatFormList = flatFormMapper.getFlatForm();
        redisService.setList(name, flatFormList);
        return flatFormList;
    }
}
