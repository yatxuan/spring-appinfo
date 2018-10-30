package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.BackendUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BackendUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    BackendUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);
}