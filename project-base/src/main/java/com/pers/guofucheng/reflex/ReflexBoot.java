package com.pers.guofucheng.reflex;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflexBoot {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("H:\\project\\spring-boot-demo\\project-base\\src\\main\\java\\com\\pers\\guofucheng\\reflex\\reflex.properties");
            properties.load(fileInputStream);
            Class<?> aClass = Class.forName(properties.getProperty("new-class"));
            Object object = aClass.newInstance();
            String method = properties.getProperty("new-method");
            Method declaredMethod = aClass.getDeclaredMethod(method);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
