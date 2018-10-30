package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.FlatForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 功能描述: <br>
 * 〈〉
 * @Author Yat-Xuan
 * @Description //TODO ASUS
 * @Date 2018/10/24 15:55
 **/
@Mapper
public interface FlatFormMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FlatForm record);

    int insertSelective(FlatForm record);

    FlatForm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlatForm record);

    int updateByPrimaryKey(FlatForm record);

    /**
     * 功能描述: <br>
     * 〈查询所有来源平台〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 15:59
     * @Param [平台]
     * @return com.xuan.springappinfo.pojo.FlatForm
     **/
    @Select("SELECT id,flatformname FROM FLATFORM")
    List<FlatForm> getFlatForm();

}