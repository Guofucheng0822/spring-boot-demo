package com.pers.guofucheng.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TestGC {
    public static void main(String[] args) {
        Vector v = new Vector(10);

        for (int i = 0; i < 100; i++) {
            Object o = new Object();
            v.add(o);
//            o = null;
        }
        System.out.println(v);
    }
}
