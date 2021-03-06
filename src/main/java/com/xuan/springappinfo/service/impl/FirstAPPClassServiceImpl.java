package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.FirstAPPClassMapper;
import com.xuan.springappinfo.pojo.FirstAPPClass;
import com.xuan.springappinfo.service.FirstAPPClassService;
import com.xuan.springappinfo.utils.redis.RedisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 16:36
 */
@Service("firstAPPClass")
public class FirstAPPClassServiceImpl implements FirstAPPClassService {

    @Resource
    private FirstAPPClassMapper firstAPPClassMapper;
    @Resource
    private RedisService redisService;

    /**
     * 储存在redis里的key
     */
    private final static String REDISREDISKEY = "firstAPPClassList";

    @Override
    public List<FirstAPPClass> getFirstAPPClass() {
        List<FirstAPPClass> firstAPPClassList;

        if (redisService.exists(REDISREDISKEY)) {
            return redisService.getList(REDISREDISKEY);
        }

        firstAPPClassList = firstAPPClassMapper.getFirstAPPClass();
        if (firstAPPClassList.size()>0) {
            redisService.setList(REDISREDISKEY, firstAPPClassList);
        }
        return firstAPPClassList;
    }
}
