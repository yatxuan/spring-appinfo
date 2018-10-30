package com.xuan.springappinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/24
 * @Time: 13:58
 */
@Mapper
public interface LoginMapper {
    /**
     * 功能描述: <br>
     * 〈通过用户名，获取该用户的密码〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 14:00
     * @Param [userCode]
     * @return java.lang.String
     **/
    @Select("select userPassword from backenduser where userCode=#{userCode}")
    String getBackendUser(String userCode);

    /**
     * 功能描述: <br>
     * 〈通过用户名，获取该用户的身份信息〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 14:01
     * @Param [userCode]
     * @return java.util.List<java.lang.String>
     **/
    @Select("SELECT" +
            "userType" +
            "FROM" +
            "rolesrelation r,userroles u" +
            "WHERE r.rolesId = u.id AND userCode=#{userCode}")
    List<String> getRoles(String userCode);

    /**
     * 功能描述: <br>
     * 〈通过用户名，获取该用户的权限信息〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 14:02
     * @Param [userCode]
     * @return java.util.List<java.lang.String>
     **/
    @Select("SELECT" +
            "permissionName" +
            "FROM" +
            "rolesrelation r, userroles u, permissionsrelation pl, permissions p" +
            "WHERE" +
            "r.rolesId = u.id AND u.id = pl.roles AND pl.permissions = p.id AND userCode=#{userCode}")
    List<String> getPermissions(String userCode);
}
