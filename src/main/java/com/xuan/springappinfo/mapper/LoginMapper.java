package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.utils.entity.User;
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
     * 〈通过用户名，从管理者表获取该用户的密码〉
     *
     * @return java.lang.String
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 14:00
     * @Param [userCode]
     **/
    @Select("SELECT " +
            "id, " +
            "userCode `code`, " +
            "userPassword `password`, " +
            "userName `name` " +
            "FROM " +
            "backenduser " +
            "WHERE  userCode=#{userCode} ")
    User getBackendUser(String userCode);

    /**
     * 功能描述: <br>
     * 〈通过用户名，从开发者表获取该用户的信息〉
     *
     * @return java.util.List<java.lang.String>
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 14:01
     * @Param [userCode]
     **/
    @Select("SELECT " +
            "id, " +
            "devCode `code`, " +
            "devPassword `password`, " +
            "devName `name` " +
            "FROM " +
            "devuser " +
            "WHERE devCode=#{userCode}")
    User getDevUser(String userCode);

    /**
     * 功能描述: <br>
     * 〈通过用户名，获取该用户的身份信息〉
     *
     * @return java.util.List<java.lang.String>
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 14:01
     * @Param [userCode]
     **/
    @Select("SELECT " +
            "userType " +
            "FROM " +
            "rolesrelation r,userroles u " +
            "WHERE r.rolesId = u.id AND code=#{userCode}")
    List<String> getRoles(String userCode);

    /**
     * 功能描述: <br>
     * 〈通过用户名，获取该用户的权限信息〉
     *
     * @return java.util.List<java.lang.String>
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 14:02
     * @Param [userCode]
     **/
    @Select("SELECT " +
            "permissionName " +
            "FROM " +
            "rolesrelation r, userroles u, permissionsrelation pl, permissions p " +
            "WHERE " +
            "r.rolesId = u.id AND u.id = pl.roles AND pl.permissions = p.id AND code=#{userCode}")
    List<String> getPermissions(String userCode);

}
