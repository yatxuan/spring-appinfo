package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.AppVersion;
import com.xuan.springappinfo.utils.entity.Storage;
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

    @Select("SELECT\n" +
            "\taf.softwareName `softwareName`,\n" +
            "\tversionNo,\n" +
            "\tversionSize,\n" +
            "\treleaseStatusName,\n" +
            "\tapkFileName,\n" +
            "\tmodifyDate,\n " +
            "\tapkLocPath " +
            "FROM\n" +
            "\tappversion app,\n" +
            "\tappinfos af,\n" +
            "\treleasestatus r\n" +
            "WHERE\n" +
            "\tapp.appInfoId = af.id\n" +
            "AND app.releaseStatusId = r.id\n" +
            "AND appInfoId = #{id}")
    List<Storage> getAppVersionS(int id);
}
