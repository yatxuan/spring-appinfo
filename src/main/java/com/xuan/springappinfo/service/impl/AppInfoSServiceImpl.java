package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.AppInfoSMapper;
import com.xuan.springappinfo.pojo.AppInfoS;
import com.xuan.springappinfo.service.AppInfoSService;
import com.xuan.springappinfo.utils.Page;
import com.xuan.springappinfo.utils.Result;
import com.xuan.springappinfo.utils.entity.Condition;
import com.xuan.springappinfo.utils.entity.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/25
 * @Time: 16:05
 */
@Service("appInfoSService")
@Slf4j
public class AppInfoSServiceImpl implements AppInfoSService {

    @Resource
    private AppInfoSMapper appInfoSMapper;

    @Override
    public List<Storage> getAppInfoS(Condition condition, Page page) {

        Map<String, Object> map = getMap(condition, page);

        return appInfoSMapper.getAppInfoS(map);
    }

    @Override
    public Page getAppInfoSCount(Condition condition) {

        Map<String, Object> map = getMap(condition, null);

        int totalSize = appInfoSMapper.getAppInfoSCount(map);

        Page page = new Page();
        page.setSize(condition.getSize());
        page.setTotalSize(totalSize);
        page.setCurrNo(condition.getCurrNo());

        return page;
    }

    @Override
    public Result saveAppInfo(AppInfoS appinfos) {

        int selective = appInfoSMapper.insertSelective(appinfos);
        if (selective > 0) {
            return Result.getSuccess();
        }
        return Result.getFailure();
    }

    @Override
    @Transactional
    public Result updateAppinfoS(AppInfoS appInfoS) {
        int selective = appInfoSMapper.updateByPrimaryKeySelective(appInfoS);
        if (selective > 0) {
            return Result.getSuccess();
        }
        return Result.getFailure();
    }


    @Override
    public Result getAppInfoId(Integer id) {
        Storage storage = appInfoSMapper.getAppInfoId(id);
        return Result.getClass(storage);
    }

    @Override
    public Result getAppinfoVersion(Integer id) {
        Storage storage = appInfoSMapper.getAppInfoId(id);
        if (storage.getVersionId() <= 0) {
            log.info("该APP没有版本信息，请先新增版本信息");
            return Result.getCustomize(false, -1, "该APP没有版本信息，请先新增版本信息");
        }

        if (storage.getFrameId() == 2) {
            log.info("该APP状态为【已上架】，只能新增版本信息");
            return Result.getCustomize(false, -1, "该APP状态为【已上架】，只能新增版本信息");
        }

        return Result.getClass(storage);
    }

    @Override
    public Result getAppinfo(int id) {
        Storage storage = appInfoSMapper.getAppInfoId(id);

        if (storage.getStatusId() == 2) {
            log.info("该APP已审核通过，不能修改信息");
            return Result.getCustomize(false, -1, "该APP已审核通过，不能修改信息");
        }

        return Result.getClass(storage);
    }

    @Override
    public Result updateAppStatus(AppInfoS appInfoS) {
        int update = appInfoSMapper.updateByPrimaryKeySelective(appInfoS);
        if (update > 0) {
            return Result.getSuccess();
        }
        return Result.getError();
    }

    @Override
    public Result appShelf(Integer appid) {
        Storage storage = appInfoSMapper.getAppstatusId(appid);
        if (storage.getStatusId() != 2) {
            log.info("该APP还未通过审核，不能上架");
            return Result.getCustomize(false, -1, "该APP还未通过审核，不能上架");
        }

        if (storage.getFrameId() == 2) {
            log.info("该APP已上架，不能重复上架");
            return Result.getCustomize(false, -1, "该APP已上架，不能重复上架");
        }

        if (storage.getVersionId() == null || storage.getVersionId() == 0) {
            log.info("该APP没有版本，请新增版本后，在进行上传");
            return Result.getCustomize(false, -1, "该APP没有版本，请新增版本后，在进行上架");
        }

        try {
            AppInfoS appInfoS = new AppInfoS();
            appInfoS.setId(appid);
            appInfoS.setFrameid(2);
            appInfoS.setOnsaledate(new Date());

            appInfoSMapper.updateByPrimaryKeySelective(appInfoS);

            log.info("上架成功");
            return Result.getCustomize(true, 0, "上架成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("上架失败");
        return Result.getCustomize(false, -1, "上架失败");
    }

    @Override
    public Result appObtained(Integer appid) {
        Storage storage = appInfoSMapper.getAppstatusId(appid);
        if (storage.getStatusId() != 2) {
            log.info("该APP还未通过审核，不能下架");
            return Result.getCustomize(false, -1, "该APP还未通过审核，不能下架");
        }

        if (storage.getFrameId() == 1) {
            log.info("该APP还未上架，不能下架");
            return Result.getCustomize(false, -1, "该APP还未上架，不能下架");
        }
        if (storage.getFrameId() == 3) {
            log.info("该APP已下架，不能重复下架");
            return Result.getCustomize(false, -1, "该APP已下架，不能重复下架");
        }

        try {
            AppInfoS appInfoS = new AppInfoS();
            appInfoS.setId(appid);
            appInfoS.setFrameid(3);
            appInfoS.setOffsaledate(new Date());

            appInfoSMapper.updateByPrimaryKeySelective(appInfoS);

            log.info("下架成功");
            return Result.getCustomize(true, 0, "下架成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("下架失败");
        return Result.getCustomize(false, -1, "下架失败");
    }

    @Override
    public Result addVersion(Integer appid) {
        return null;
    }


    public static Map<String, Object> getMap(Condition condition, Page page) {
        Map<String, Object> map = new HashMap<>(16);
        if (condition != null) {
            map.put("appId", condition.getAppId());
            map.put("softwareName", condition.getSoftwareName());
            map.put("flatFormId", condition.getFlatFormId());
            map.put("firstAPPClassId", condition.getFirstAPPClassId());
            map.put("twoAPPClassId", condition.getTwoAPPClassId());
            map.put("threeAPPClassId", condition.getThreeAPPClassId());
            map.put("devUserId", condition.getDevUserId());
            map.put("frameId", condition.getFrameId());
            map.put("statusId", condition.getStatusId());
        }

        if (page != null) {
            int currNo = (page.getCurrNo() - 1) * page.getSize();
            map.put("currNo", currNo);
            map.put("size", page.getSize());
        }

        return map;
    }
}

