package com.pers.guofucheng.linkedList;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * LinkedList的测试
 *
 * @author guofucheng
 * @date 2021/03/03
 */
public class LinkedListTest {

    @Test
    public void test1(){
        LinkedList list=new LinkedList();
        list.add(111);
        Object o = list.get(0);
        System.out.println(o);
//        ListIterator listIterator = list.listIterator();
//        while (listIterator.hasNext()){
//            Object next = listIterator.next();
//            System.out.println(next);
//        }
    }

}
