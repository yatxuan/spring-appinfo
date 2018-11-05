package com.xuan.springappinfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/11/5 0005
 * @Time: 10:18
 */
public class Test {
    public static void main(String[] args) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2005-06-09");
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
