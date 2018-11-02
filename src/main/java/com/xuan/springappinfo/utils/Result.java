package com.xuan.springappinfo.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据返回类
 *
 * @author ASUS
 */

public class Result {

    /**
     * 返回请求是否成功
     */
    private boolean success;

    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 返回报错描述
     */
    private String message;

    /**
     * 返回响应的数据
     */
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Result(ResultCode resultCode, Object data) {
        this(resultCode);
        this.data = data;
    }

    private Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.success = resultCode.isBool();
    }

    private Result(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public static Result getListAndPage(Page page, List list) {
        if (list.size() > 0) {
            Map<String, Object> map = new HashMap<>(16);
            map.put("page", page);
            map.put("list", list);

            return new Result(ResultCode.SUCCESS, map);
        } else {
            return getFailure();
        }
    }

    public static Result getClass(Object object) {
        if (object != null) {
            return new Result(ResultCode.SUCCESS, object);
        } else {
            return getFailure();
        }
    }

    public static Result getList(List objectlist) {
        if (objectlist.size() > 0) {
            return new Result(ResultCode.SUCCESS, objectlist);
        } else {
            return getFailure();
        }
    }

    /**
     * 自定义返回信息
     *
     * @param success
     * @param code
     * @param message
     * @return
     */
    public static Result getCustomize(boolean success, int code, String message) {
        return new Result(success, code, message);
    }

    /**
     * 请求失败
     *
     * @return
     */
    public static Result getFailure() {
        return new Result(ResultCode.FAILURE);
    }

    /**
     * 请求成功
     *
     * @return
     */
    public static Result getSuccess() {
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 请求报错
     *
     * @return
     */
    public static Result getError() {
        return new Result(ResultCode.ERROR);
    }
}
