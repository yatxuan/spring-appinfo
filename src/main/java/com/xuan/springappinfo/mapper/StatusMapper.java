package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.Status;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Status record);

    int insertSelective(Status record);

    Status selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Status record);

    int updateByPrimaryKey(Status record);

    /**
     * <p>Description: 查询审核表的所有数据 </p>
     * @author Yat-Xuan
     * @params: []
     * @return: java.util.List<com.xuan.springappinfo.pojo.Status>
     * @Date: 2018/11/2 0002 9:26
     * @Modified By:
    */
    @Select("select * from `status`")
    List<Status> getStatus();
}
