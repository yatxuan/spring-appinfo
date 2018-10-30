package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.PermissionsRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionsRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermissionsRelation record);

    int insertSelective(PermissionsRelation record);

    PermissionsRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermissionsRelation record);

    int updateByPrimaryKey(PermissionsRelation record);
}