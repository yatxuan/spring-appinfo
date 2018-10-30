package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.AppVersion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AppVersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppVersion appVersion);

    int insertSelective(AppVersion appVersion);

    AppVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    @Select("SELECT * from appversion where appInfoId=#{id}")
    List<AppVersion> getAppVersionS(int id);
}