package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.DevUserRecordChange;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DevUserRecordChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DevUserRecordChange record);

    int insertSelective(DevUserRecordChange record);

    DevUserRecordChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DevUserRecordChange record);

    int updateByPrimaryKey(DevUserRecordChange record);
}