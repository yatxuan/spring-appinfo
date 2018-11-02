package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.InterfaceLanguage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InterfaceLanguageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InterfaceLanguage record);

    int insertSelective(InterfaceLanguage record);

    InterfaceLanguage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InterfaceLanguage record);

    int updateByPrimaryKey(InterfaceLanguage record);

    /**
     * <p>Description: 查询所有语言 </p>
     * @author Yat-Xuan
     * @params: []
     * @return: java.util.List<com.xuan.springappinfo.pojo.InterfaceLanguage>
     * @Date: 2018/11/2 0002 23:39
     * @Modified By:
    */
    @Select("select * from InterfaceLanguage")
    List<InterfaceLanguage> getInterfaceLanguageS();
}
