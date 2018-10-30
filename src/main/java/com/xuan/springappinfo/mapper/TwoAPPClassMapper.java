package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.TwoAPPClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TwoAPPClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TwoAPPClass record);

    int insertSelective(TwoAPPClass record);

    TwoAPPClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TwoAPPClass record);

    int updateByPrimaryKey(TwoAPPClass record);

    /**
     * 功能描述: <br>
     * 〈通过一级分类的id，获取对应的二级分类数据〉
     *
     * @return com.xuan.springappinfo.pojo.TwoAPPClass 二级分类数据
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 16:45
     * @Param [firstAPPClassId] 一级分类id
     **/
    @Select("select id,twoAPPName from twoappclass where firstAPPClassId=#{firstAPPClassId}")
    List<TwoAPPClass> getTwoAPPClass(int firstAPPClassId);
}