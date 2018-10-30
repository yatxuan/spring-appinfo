package com.xuan.springappinfo.service;

import com.xuan.springappinfo.pojo.ThreeAPPClass;

import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 16:47
 */
public interface ThreeAPPClassService {

    /**
     * 功能描述: <br>
     * 〈通过二级分类id，获取对应的三级分类的数据〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 16:48
     * @Param [twoAPPClassId]
     * @return com.xuan.springappinfo.pojo.ThreeAPPClass
     **/
    List<ThreeAPPClass> getThreeAPPClass(int twoAPPClassId);
}
