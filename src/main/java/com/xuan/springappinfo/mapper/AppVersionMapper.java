package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.AppVersion;
import com.xuan.springappinfo.utils.entity.Storage;
import org.apache.ibatis.annotations.Delete;
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
            "app.id `appVersionId`," +
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

    @Select("select * from appversion where id=#{appVersionId}")
    AppVersion getAppVersionId(Integer appVersionId);

    /**
     * <p>Description: 通过APP软件id，删除版本信息 </p>
     *
     * @author Yat-Xuan
     * @params: [id]
     * @return: int
     * @Date: 2018/11/7 0007 10:30
     * @Modified By:
     */
    @Delete("delete from appversion where appInfoId=#{id}")
    int delAPPVersionAppinfoId(Integer id);
}
