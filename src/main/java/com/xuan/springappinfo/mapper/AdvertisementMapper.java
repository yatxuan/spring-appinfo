package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.Advertisement;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdvertisementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Advertisement record);

    int insertSelective(Advertisement record);

    Advertisement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Advertisement record);

    int updateByPrimaryKey(Advertisement record);
}