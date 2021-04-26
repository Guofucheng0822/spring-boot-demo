package com.pers.guofucheng.jihe;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
    @Test
    public void test1(){
        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(0);
        copyOnWriteArrayList.add(1,1);
        copyOnWriteArrayList.remove("");
    }
}
