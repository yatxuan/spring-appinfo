package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.TwoAPPClassMapper;
import com.xuan.springappinfo.pojo.TwoAPPClass;
import com.xuan.springappinfo.service.TwoAPPClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 16:45
 */
@Service("twoAPPClassService")
public class TwoAPPClassServiceImpl implements TwoAPPClassService {

    @Resource
    private TwoAPPClassMapper twoAPPClassMapper;

    @Override
    public List<TwoAPPClass> getTwoAPPClass(int firstAPPClassId) {
        return twoAPPClassMapper.getTwoAPPClass(firstAPPClassId);
    }
}
