package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.ThreeAPPClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ThreeAPPClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ThreeAPPClass record);

    int insertSelective(ThreeAPPClass record);

    ThreeAPPClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ThreeAPPClass record);

    int updateByPrimaryKey(ThreeAPPClass record);

    /**
     * 功能描述: <br>
     * 〈通过二级分类的id，获取对应的三级分类的数据〉
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/24 16:49
     * @Param [twoAPPClassId] 二级分类的id
     * @return com.xuan.springappinfo.pojo.ThreeAPPClass
     **/
    @Select("select id,threeAPPName from threeAPPClass where twoAPPClassId=#{twoAPPClassId}")
    List<ThreeAPPClass> getThreeAPPClass(int twoAPPClassId);
}