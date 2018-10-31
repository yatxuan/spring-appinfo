package com.xuan.springappinfo.utils.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 保存所有用户信息
 *
 * @Author: YatXuan
 * @Date: 2018/10/31 0031 14:56
 **/
@Getter
@Setter
public class User {

    private int id;
    private String code;
    private String passWord;
    private String name;
    private Integer roles;


}
