package com.xuan.springappinfo.service;

import com.xuan.springappinfo.mapper.FlatFormMapper;
import com.xuan.springappinfo.pojo.FlatForm;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 平台类 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 15:53
 */
public interface FlatFormService {

    /**
     * 功能描述: <br>
     * 〈查询所有平台信息〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 15:56
     * @Param []
     * @return com.xuan.springappinfo.pojo.FlatForm
     **/
    List<FlatForm> getFlatForm();
}
