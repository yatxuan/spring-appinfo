package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.UserRoles;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoles record);

    int insertSelective(UserRoles record);

    UserRoles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoles record);

    int updateByPrimaryKey(UserRoles record);
}