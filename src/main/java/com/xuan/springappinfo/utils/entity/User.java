package com.xuan.springappinfo.utils.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 保存所有用户信息
 *
 * @Author: YatXuan
 * @Date: 2018/10/31 0031 14:56
 **/
@Getter
@Setter
@ToString
public class User {

    private int id;
    private String code;
    private String passWord;
    private String name;
    private String roles;


}
