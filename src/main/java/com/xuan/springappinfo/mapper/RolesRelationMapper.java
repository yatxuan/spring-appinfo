package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.RolesRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolesRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolesRelation record);

    int insertSelective(RolesRelation record);

    RolesRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolesRelation record);

    int updateByPrimaryKey(RolesRelation record);
}