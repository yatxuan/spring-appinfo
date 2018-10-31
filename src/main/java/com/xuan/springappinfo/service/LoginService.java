package com.xuan.springappinfo.service;

import java.util.List;

/**
 * <p>Description: Shiro权限查询表 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 13:57
 */
public interface LoginService {

    /**
     * 功能描述: <br>
     * 〈通过用户名获取，该用户的密码〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 14:00
     * @Param [userCode] 用户名
     * @return java.lang.String
     **/
    String getUser(String userCode);

    /**
     * 功能描述: <br>
     * 〈通过用户名，获取该用户的身份信息〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 14:13
     * @Param [userCode] 用户名
     * @return java.util.List<java.lang.String>
     **/
    List<String> getRoles(String userCode);

    /**
     * 功能描述: <br>
     * 〈通过用户名，获取该用户的权限信息〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 14:02
     * @Param [userCode] 用户名
     * @return java.util.List<java.lang.String>
     **/
    List<String> getPermissions(String userCode);
}
