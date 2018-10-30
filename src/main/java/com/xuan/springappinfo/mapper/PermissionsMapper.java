package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.Permissions;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Permissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);
}