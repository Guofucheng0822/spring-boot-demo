package com.pers.guofucheng.hash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestHash {
        public static void main(String[] args) {
        // 1.java中String.hashCode()方法的算法如下：
        // str.charAt(0) * 31n-1 + str.charAt(1) * 31n-2 + ... + str.charAt(n-1)
        String a="Aa";
        String b="BB";
        int aa=a.hashCode();
        int bb=b.hashCode();
        System.out.println(aa);
        System.out.println(bb);
    }
//    public static void main(String[] args) {
//        HashMap<Integer, Integer> m = new LinkedHashMap<Integer, Integer>(10, 0.75f, false);
//        m.put(3, 11);
//        m.put(1, 12);
//        m.put(5, 23);
//        m.put(2, 22);
//
//        m.put(3, 26);
//        m.get(10);
//        for (Map.Entry e : m.entrySet()) {
//            System.out.println(e.getKey());
//        }
//    }
}
