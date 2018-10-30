package com.xuan.springappinfo.service;

import com.xuan.springappinfo.pojo.FirstAPPClass;

import java.util.List;

/**
 * <p>Description: 一级分类 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 16:36
 */
public interface FirstAPPClassService {

    /**
     * 功能描述: <br>
     * 〈获取所有一级分类〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 16:36
     * @Param []
     * @return com.xuan.springappinfo.pojo.FirstAPPClass
     **/
    List<FirstAPPClass> getFirstAPPClass();
}
