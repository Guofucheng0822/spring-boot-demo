package com.pers.guofucheng.reflex;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflexTest {
    public static void main(String[] args) {
        try {
            //获取class对象
//            Class<?> aClass = Class.forName("com.pers.guofucheng.reflex.User");
            Class<?> aClass =User.class;
            //通过class对象获取所有public修饰的成员变量
            Field[] fields = aClass.getFields();
            Field[] declaredFields = aClass.getDeclaredFields();
            System.out.println(JSON.toJSONString(fields));
            System.out.println(JSON.toJSONString(declaredFields));
            Field name = aClass.getField("name");
            System.out.println(name);
            Method[] methods = aClass.getMethods();
            System.out.println(JSON.toJSONString(methods));
            User user = new User();
            user.setName("aaa");
            user.setAge(10);
            Class<? extends User> aClass1 = user.getClass();
            Field[] fields1 = aClass1.getFields();
            Object o = fields1[0].get(user);
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
