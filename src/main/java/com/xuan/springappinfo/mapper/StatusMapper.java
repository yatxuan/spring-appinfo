package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.Status;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Status record);

    int insertSelective(Status record);

    Status selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Status record);

    int updateByPrimaryKey(Status record);
}