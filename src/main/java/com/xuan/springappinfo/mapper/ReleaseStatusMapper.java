package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.ReleaseStatus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReleaseStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReleaseStatus record);

    int insertSelective(ReleaseStatus record);

    ReleaseStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReleaseStatus record);

    int updateByPrimaryKey(ReleaseStatus record);
}