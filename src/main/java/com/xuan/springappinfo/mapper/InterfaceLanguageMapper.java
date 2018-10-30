package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.InterfaceLanguage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InterfaceLanguageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InterfaceLanguage record);

    int insertSelective(InterfaceLanguage record);

    InterfaceLanguage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InterfaceLanguage record);

    int updateByPrimaryKey(InterfaceLanguage record);
}