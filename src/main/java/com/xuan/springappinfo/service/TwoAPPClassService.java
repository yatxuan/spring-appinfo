package com.xuan.springappinfo.service;

import com.xuan.springappinfo.pojo.TwoAPPClass;

import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 16:43
 */
public interface TwoAPPClassService {

    /**
     * 功能描述: <br>
     * 〈通过一级分类的id，获取对应的二级分类数据〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 16:44
     * @Param [firstAPPClassId] 一级分类id
     * @return com.xuan.springappinfo.pojo.TwoAPPClass 二级分类数据
     **/
    List<TwoAPPClass> getTwoAPPClass(int firstAPPClassId);
}
