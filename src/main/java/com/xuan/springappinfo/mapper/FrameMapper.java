package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.Frame;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FrameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Frame record);

    int insertSelective(Frame record);

    Frame selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Frame record);

    int updateByPrimaryKey(Frame record);
}