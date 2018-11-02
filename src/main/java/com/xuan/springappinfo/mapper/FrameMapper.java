package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.Frame;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FrameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Frame record);

    int insertSelective(Frame record);

    Frame selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Frame record);

    int updateByPrimaryKey(Frame record);

    @Select("select * from frame")
    List<Frame> getFrame();
}
