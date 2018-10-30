package com.xuan.springappinfo.utils;

/**
 * 信息枚举
 * @author ASUS
 */

public enum ResultCode {

    /**
     * 请求成功
     */
    SUCCESS(0, "请求成功",true),
    /**
     * 请求失败
     */
    FAILURE(0, "请求失败",false),
    /**
     * 请求失败
     */
    ERROR(-1, "网络异常，请稍后重试",false),
    /**
     * 查询不到记录
     */
    NO(-2,"没有查询到相关的记录，请重试",false);


    private int code;
    private String msg;
    private boolean bool;

    ResultCode(int code, String msg,boolean bool) {
        this.code=code;
        this.msg = msg;
        this.bool=bool;
    }

    ResultCode() {
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isBool() {
        return bool;
    }
}
