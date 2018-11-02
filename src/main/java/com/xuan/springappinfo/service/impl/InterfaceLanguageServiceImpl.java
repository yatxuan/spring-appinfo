package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.InterfaceLanguageMapper;
import com.xuan.springappinfo.pojo.InterfaceLanguage;
import com.xuan.springappinfo.service.InterfaceLanguageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/11/2 0002
 * @Time: 23:38
 */
@Service("interfaceLanguageService")
public class InterfaceLanguageServiceImpl implements InterfaceLanguageService {

    @Resource
    private InterfaceLanguageMapper interfaceLanguageMapper;

    @Override
    public List<InterfaceLanguage> getInterfaceLanguageS() {
        return interfaceLanguageMapper.getInterfaceLanguageS();
    }
}
