package com.xuan.springappinfo.service;

import com.xuan.springappinfo.pojo.AppInfoS;
import com.xuan.springappinfo.utils.Page;
import com.xuan.springappinfo.utils.Result;
import com.xuan.springappinfo.utils.entity.Condition;
import com.xuan.springappinfo.utils.entity.Storage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;
import java.util.Map;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/25
 * @Time: 16:04
 */
public interface AppInfoSService {

    /**
     * 功能描述: <br>
     * 〈查询所有App的信息〉
     *
     * @return java.util.List<com.xuan.springappinfo.pojo.AppInfoS>
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/25 16:51
     * @Param [condition, page]条件工具类 分页工具类
     **/
    List<Storage> getAppInfoS(Condition condition, Page page);

    /**
     * 功能描述: <br>
     * 〈查询所有App的信息,导出到Excel〉
     *
     * @return java.util.List<com.xuan.springappinfo.pojo.AppInfoS>
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/25 16:51
     * @Param [condition, page]条件工具类 分页工具类
     **/
    List<Map<String, Object>> getAppInfoS(Condition condition);

    /**
     * 功能描述: <br>
     * 〈查询总数据量〉
     *
     * @return com.xuan.springappinfo.utils.Page 分页工具类储存
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/25 16:50
     * @Param [condition] 条件工具类
     **/
    Page getAppInfoSCount(Condition condition);

    /**
     * 功能描述: <br>
     * 〈添加APP信息〉
     *
     * @return Result
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/27 15:48
     * @Param [appinfoS]
     **/
    Result saveAppInfo(AppInfoS appInfoS);

    /**
     * 功能描述: <br>
     * 〈修改APP基本信息〉
     *
     * @return com.xuan.springappinfo.utils.Result
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/27 15:55
     * @Param [appInfoS]
     **/
    Result updateAppinfoS(AppInfoS appInfoS);

    /**
     * @return com.xuan.springappinfo.utils.Result
     * @Author YatXuan
     * @Description 通过id查询APP信息
     * @Date 15:06 2018/10/29 0029
     * @Param [id]
     **/
    Result getAppInfoId(Integer id);

    /**
     * 功能描述: <br>
     * 〈查询是否能修改APP的版本号〉
     *
     * @return com.xuan.springappinfo.utils.Result
     * @Author YatXuan
     * @Description
     * @Date 15:58 2018/10/29 0029
     * @Param [id]
     **/
    Result getAppinfoVersion(Integer id);

    /**
     * 功能描述: <br>
     * 〈查询是否能修改APP的基本信息〉
     *
     * @return
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/27 15:57
     * @Param
     **/
    Result getAppinfo(int id);

    /**
     * 审核APP信息
     *
     * @return com.xuan.springappinfo.utils.Result
     * @Author YatXuan
     * @Description //TODO
     * @Date 16:46 2018/10/29 0029
     * @Param [appId, statusId]
     **/

    Result updateAppStatus(AppInfoS appInfoS);

    /**
     * <p>Description: APP上架功能 </p>
     *
     * @author Yat-Xuan
     * @params: [appid]
     * @return: com.xuan.springappinfo.utils.Result
     * @Date: 2018/11/2 0002 22:25
     * @Modified By:
     */
    Result appShelf(Integer appid);

    /**
     * <p>Description: APP下架功能 </p>
     *
     * @author Yat-Xuan
     * @params: [appid]
     * @return: com.xuan.springappinfo.utils.Result
     * @Date: 2018/11/2 0002 22:27
     * @Modified By:
     */
    Result appObtained(Integer appid);

    /**
     * <p>Description: 删除APP信息，及APP的所有版本 </p>
     *
     * @author Yat-Xuan
     * @params: [appid]
     * @return: com.xuan.springappinfo.utils.Result
     * @Date: 2018/11/7 0007 10:20
     * @Modified By:
     */
    Result appinfoDel(Integer appid);


    XSSFWorkbook exportExcelInfo(Condition condition) throws Exception;

}
