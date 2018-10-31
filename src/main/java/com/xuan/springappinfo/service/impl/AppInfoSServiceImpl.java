package com.xuan.springappinfo.service.impl;

import com.xuan.springappinfo.mapper.AppInfoSMapper;
import com.xuan.springappinfo.pojo.AppInfoS;
import com.xuan.springappinfo.service.AppInfoSService;
import com.xuan.springappinfo.utils.Page;
import com.xuan.springappinfo.utils.Result;
import com.xuan.springappinfo.utils.entity.Condition;
import com.xuan.springappinfo.utils.entity.Storage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/25
 * @Time: 16:05
 */
@Service("appInfoSService")
public class AppInfoSServiceImpl implements AppInfoSService {

    @Resource
    private AppInfoSMapper appInfoSMapper;

    @Override
    public List<Storage> getAppInfoS(Condition condition, Page page) {
        condition.setCurrNo((page.getCurrNo() - 1) * page.getSize());
        condition.setSize(page.getSize());
        return appInfoSMapper.getAppInfoS(condition);
    }

    @Override
    public Page getAppInfoSCount(Condition condition) {
        int totalSize = appInfoSMapper.getAppInfoSCount(condition);

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
            return Result.getCustomize(false, -1, "该APP没有版本信息，请先新增版本信息");
        }

        if (storage.getFrameId() == 2) {
            return Result.getCustomize(false, -1, "该APP状态为【已上架】，只能新增版本信息");
        }

        return Result.getClass(storage);
    }

    @Override
    public Result getAppinfo(int id) {
        Storage storage = appInfoSMapper.getAppInfoId(id);

        if (storage.getStatusId() == 2) {
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
}

