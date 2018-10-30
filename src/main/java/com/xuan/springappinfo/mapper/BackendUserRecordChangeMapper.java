package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.BackendUserRecordChange;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BackendUserRecordChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BackendUserRecordChange record);

    int insertSelective(BackendUserRecordChange record);

    BackendUserRecordChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackendUserRecordChange record);

    int updateByPrimaryKey(BackendUserRecordChange record);
}