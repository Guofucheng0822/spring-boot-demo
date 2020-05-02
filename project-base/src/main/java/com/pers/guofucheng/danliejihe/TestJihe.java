package com.pers.guofucheng.danliejihe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public class TestJihe<T> {
    public static void main(String[] args) {
        List<String> list=new ArrayList(16);
        list.add("1");
        list.add("2");
        list.add("3");
        for (String s : list) {

        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            ((ArrayList) list).add(4);
        }
    }
}
