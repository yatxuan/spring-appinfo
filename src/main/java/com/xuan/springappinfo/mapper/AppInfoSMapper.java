package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.AppInfoS;
import com.xuan.springappinfo.utils.entity.Condition;
import com.xuan.springappinfo.utils.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppInfoSMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppInfoS appInfoS);

    int insertSelective(AppInfoS appInfoS);

    AppInfoS selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppInfoS record);

    int updateByPrimaryKey(AppInfoS record);

    /**
     * 功能描述: <br>
     * 〈查询APP的总数量〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/25 16:54
     * @Param [condition]
     * @return com.xuan.springappinfo.utils.Page
     **/
    int getAppInfoSCount(Condition condition);

    List<Storage> getAppInfoS(Condition condition);

    /**
     * @Author YatXuan
     * @Description 通过id查询APP信息
     * @Date 15:15 2018/10/29 0029
     * @Param [id]
     * @return com.xuan.springappinfo.utils.entity.Storage
     **/
    Storage getAppInfoId(@Param("appId") Integer id);

    /**
     * 功能描述: <br>
     * 〈查询APP的版本号是否存在〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/27 15:57
     * @Param
     * @return
     **/
}