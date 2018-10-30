package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.FirstAPPClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FirstAPPClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FirstAPPClass record);

    int insertSelective(FirstAPPClass record);

    FirstAPPClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FirstAPPClass record);

    int updateByPrimaryKey(FirstAPPClass record);

    @Select("SELECT id,firstAPPName FROM firstappclass")
    List<FirstAPPClass> getFirstAPPClass();
}