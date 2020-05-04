package com.pers.guofucheng.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public class TestMap {

    public static void main(String[] args) {
        Map map=new HashMap(16);
        Object a = map.put("a", "100");
        System.out.println(map);
        Object b = map.put("b", "200");
        Object a1 = map.put("a", "300");
        System.out.println(map);
        System.out.println(a1);
    }
}
