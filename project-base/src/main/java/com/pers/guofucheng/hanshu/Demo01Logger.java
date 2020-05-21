package com.pers.guofucheng.hanshu;

import java.util.Arrays;
import java.util.Comparator;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public class Demo01Logger {
    private static void log(int level, MyFunctionalInterface myFunctionalInterface) {
        if (level==1){
            myFunctionalInterface.eat();

        }
    }
    public static Comparator<String> newComparator(){
        return Comparator.comparingInt(String::length);
    }

    public static void main(String[] args) {
//Lambda表达式延迟执行
//        log(2, () -> {
//            System.out.println("Lambda执行！");
//            System.out.println("a"+"b"+"c");});
        //测试排序接口
        String [] arr={"abc","ghip","def"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, newComparator());
        System.out.println(Arrays.toString(arr));
    }
}