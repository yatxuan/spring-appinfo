package com.xuan.springappinfo.mapper;

import com.xuan.springappinfo.pojo.AppInfoS;
import com.xuan.springappinfo.utils.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppInfoSMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppInfoS appInfoS);

    int insertSelective(AppInfoS appInfoS);

    AppInfoS selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppInfoS record);

    int updateByPrimaryKey(AppInfoS record);

    /**
     * <p>Description:查询APP的总数量 </p>
     * @author Yat-Xuan
     * @params: [map]
     * @return: int
     * @Date: 2018/11/2 0002 17:01
     * @Modified By:
    */
    int getAppInfoSCount(Map<String, Object> map);

    /**
     * <p>Description: 查询APP的总数据信息 </p>
     * @author Yat-Xuan
     * @params: [map]
     * @return: java.util.List<com.xuan.springappinfo.utils.entity.Storage>
     * @Date: 2018/11/2 0002 17:02
     * @Modified By:
    */
    List<Storage> getAppInfoS(Map<String, Object> map);

    /**
     * @return com.xuan.springappinfo.utils.entity.Storage
     * @Author YatXuan
     * @Description 通过id查询APP信息
     * @Date 15:15 2018/10/29 0029
     * @Param [id]
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
