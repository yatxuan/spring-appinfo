package com.xuan.springappinfo;

import com.xuan.springappinfo.utils.entity.Condition;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/25
 * @Time: 16:17
 */
public class Main {
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        Map<String, Object> map = new HashMap<>(16);

        Condition condition = new Condition();
        condition.setAppId(1);
        condition.setSoftwareName("名称");
        condition.setCurrNo(123);
        Class<?> clazz = condition.getClass();

        //获得实体类名
        Field[] fields = condition.getClass().getDeclaredFields();//获得属性
        System.out.println(fields.length);
//获得Object对象中的所有方法
        for (Field field : fields) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
            System.out.println(field);
            Method getMethod = pd.getReadMethod();//获得get方法
            System.out.println(field.getName());
            System.out.println("-------------------------");
            Object invoke = getMethod.invoke(condition);//此处为执行该Object对象的get方法
            if (invoke instanceof Integer) {
                if ((int) invoke != 0) {
                    map.put(field.getName(), invoke);
                }
                continue;
            }
            if (invoke instanceof String) {
                String str = (String) invoke;
                if (str != null && !str.equals("")) {
                    map.put(field.getName(), invoke);
                }
            }
//            Method setMethod = pd.getWriteMethod();//获得set方法
//            setMethod.invoke(condition, "参数");//此处为执行该Object对象的set方法
        }
        System.out.println(map.size());
        System.out.println(map.toString());
    }
}
