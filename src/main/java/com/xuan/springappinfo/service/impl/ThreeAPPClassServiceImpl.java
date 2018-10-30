package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.ThreeAPPClassMapper;
import com.xuan.springappinfo.pojo.ThreeAPPClass;
import com.xuan.springappinfo.service.ThreeAPPClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 16:48
 */
@Service("threeAPPClassService")
public class ThreeAPPClassServiceImpl implements ThreeAPPClassService {

    @Resource
    private ThreeAPPClassMapper threeAPPClassMapper;

    @Override
    public List<ThreeAPPClass> getThreeAPPClass(int twoAPPClassId) {
        return threeAPPClassMapper.getThreeAPPClass(twoAPPClassId);
    }
}
