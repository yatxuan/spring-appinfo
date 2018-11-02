package com.xuan.springappinfo.pojo;

/**
 * <p>Description: 审核 </p>
 * @author Yat-Xuan
 * @Date: 2018/11/2 0002 9:23
 * @Modified By:
*/
public class Status {
    private Integer id;

    private String statustype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatustype() {
        return statustype;
    }

    public void setStatustype(String statustype) {
        this.statustype = statustype == null ? null : statustype.trim();
    }
}
