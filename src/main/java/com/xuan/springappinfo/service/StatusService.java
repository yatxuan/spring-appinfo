package com.xuan.springappinfo.service;

import com.xuan.springappinfo.pojo.Status;

import java.util.List;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/11/2 0002
 * @Time: 9:24
 */
public interface StatusService {
    /**
     * <p>Description: 查询审核表的数据 </p>
     * @author Yat-Xuan
     * @params: []
     * @return: java.util.List<com.xuan.springappinfo.pojo.Status>
     * @Date: 2018/11/2 0002 9:25
     * @Modified By:
    */
    List<Status> getStatus();
}
