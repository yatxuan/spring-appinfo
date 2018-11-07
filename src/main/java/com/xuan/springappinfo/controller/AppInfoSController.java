package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.pojo.AppInfoS;
import com.xuan.springappinfo.service.AppInfoSService;
import com.xuan.springappinfo.utils.Page;
import com.xuan.springappinfo.utils.Result;
import com.xuan.springappinfo.utils.entity.Condition;
import com.xuan.springappinfo.utils.entity.Storage;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/25
 * @Time: 16:04
 */
@RestController
@RequestMapping("/appInfoS")
@Slf4j
public class AppInfoSController {

    @Resource
    private AppInfoSService appInfoSService;

    /**
     * @return com.xuan.springappinfo.utils.Result
     * @Author YatXuan
     * @Description 多条件查询APP基本信息
     * @Date 15:00 2018/10/29 0029
     * @Param [condition]
     **/
    @RequestMapping("/getAppInfoS")
    public Result getAppInfoS(Condition condition) {

        Page page = appInfoSService.getAppInfoSCount(condition);
        List<Storage> appInfoS = appInfoSService.getAppInfoS(condition, page);

        return Result.getListAndPage(page, appInfoS);
    }

    /**
     * @return com.xuan.springappinfo.utils.Result
     * @Author YatXuan
     * @Description 新增APP信息
     * @Date 15:00 2018/10/29 0029
     * @Param [appInfoS]
     **/
    @RequestMapping("/saveAppInfo")
    public Result saveAppInfo(AppInfoS appInfoS) {
        appInfoS.setCreationdate(new Date());
        return appInfoSService.saveAppInfo(appInfoS);

    }

    /**
     * @return com.xuan.springappinfo.utils.Result
     * @Author YatXuan
     * @Description 修改APP信息
     * @Date 15:01 2018/10/29 0029
     * @Param [appInfoS]
     **/
    @RequestMapping("/updateAppinfoS")
    public Result updateAppinfoS(AppInfoS appInfoS) {
        return appInfoSService.updateAppinfoS(appInfoS);
    }

    /**
     * @return com.xuan.springappinfo.utils.Result
     * @Author YatXuan
     * @Description 通过id查询APP信息
     * @Date 15:06 2018/10/29 0029
     * @Param [id]
     **/
    @RequestMapping("/getAppInfoId")
    public Result getAppInfoId(Integer id) {
        return appInfoSService.getAppInfoId(id);
    }

    /**
     * @return
     * @Author YatXuan
     * @Description 查询是否能修改APP的版本号
     * @Date 15:56 2018/10/29 0029
     * @Param
     **/
    @RequestMapping("/getAppinfoVersion")
    public Result getAppinfoVersion(Integer id) {
        return appInfoSService.getAppinfoVersion(id);
    }

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
    @RequestMapping("/getAppinfo")
    public Result getAppinfo(int id) {
        return appInfoSService.getAppinfo(id);
    }

    /**
     * 审核APP
     *
     * @return com.xuan.springappinfo.utils.Result
     * @Author YatXuan
     * @Description //TODO
     * @Date 16:45 2018/10/29 0029
     * @Param [appId, statusId]
     **/
    @RequestMapping("/updateAppStatus")
    public Result updateAppStatus(AppInfoS appInfoS) {
        return appInfoSService.updateAppStatus(appInfoS);
    }

    /**
     * <p>Description: APP上架功能 </p>
     *
     * @author Yat-Xuan
     * @params: [appid]
     * @return: com.xuan.springappinfo.utils.Result
     * @Date: 2018/11/2 0002 22:25
     * @Modified By:
     */
    @RequestMapping("/appShelf")
    public Result appShelf(@RequestParam(name = "appid") Integer appid) {
        return appInfoSService.appShelf(appid);
    }

    /**
     * <p>Description: APP下架功能 </p>
     *
     * @author Yat-Xuan
     * @params: [appid]
     * @return: com.xuan.springappinfo.utils.Result
     * @Date: 2018/11/2 0002 22:27
     * @Modified By:
     */
    @RequestMapping("/appObtained")
    public Result appObtained(@RequestParam(name = "appid") Integer appid) {
        return appInfoSService.appObtained(appid);
    }

    /**
     * <p>Description: 修改APP版本 </p>
     *
     * @author Yat-Xuan
     * @params: [appid, appVersionId] AppID APP版本ID
     * @return: com.xuan.springappinfo.utils.Result
     * @Date: 2018/11/6 0006 10:54
     * @Modified By:
     */
    @RequestMapping("/modifiedVersion")
    public Result modifiedVersion(AppInfoS appInfoS) {
        appInfoS.setUpdatedate(new Date());
        return appInfoSService.updateAppStatus(appInfoS);
    }

    /**
     * <p>Description: 删除APP信息，及APP的所有版本 </p>
     *
     * @author Yat-Xuan
     * @params: [appid]
     * @return: com.xuan.springappinfo.utils.Result
     * @Date: 2018/11/7 0007 10:20
     * @Modified By:
     */
    @RequestMapping("/appinfoDel")
    public Result appinfoDel(@RequestParam(name = "appid") Integer appid) {
        return appInfoSService.appinfoDel(appid);
    }

    @RequestMapping("/exportExcel")
    public void exportExcel(Condition condition, HttpServletRequest request, HttpServletResponse response,String querySoftwareName) throws Exception {

        log.info("导出数据-->开始");

        condition.setSoftwareName(querySoftwareName);

        response.reset(); //清除buffer缓存
        //Map<String,Object> map=new HashMap<String,Object>();
        // 指定下载的文件名
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String("APP信息表.xlsx".getBytes(), "iso-8859-1"));
        //导出Excel对象
        XSSFWorkbook workbook = appInfoSService.exportExcelInfo(condition);
        OutputStream output;
        try {
            output = response.getOutputStream();
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.flush();
            workbook.write(bufferedOutput);
            bufferedOutput.close();
            log.info("导出-->完成");
        } catch (IOException e) {
            log.info("导出异常");
            e.printStackTrace();
        }
    }

}
