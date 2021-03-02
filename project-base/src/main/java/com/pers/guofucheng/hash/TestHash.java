package com.pers.guofucheng.hash;

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
}
