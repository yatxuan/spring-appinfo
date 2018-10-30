package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.DevUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DevUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);

    /**
     * @Author YatXuan
     * @Description //TODO
     * @Date 16:14 2018/10/30 0030
     * @Param []
     * @return java.util.List<com.xuan.springappinfo.pojo.DevUser>
     **/
    @Select("select * from DevUser")
    List<DevUser> getDevUsers();
}