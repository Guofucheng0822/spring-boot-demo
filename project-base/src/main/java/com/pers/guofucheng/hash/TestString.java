package com.pers.guofucheng.hash;

public class TestString {
    public static void main(String[] args) {
        final String s1="a";
        final String s2="a";
         String s3=s1+s2;
        // 将s3写入字符串常量池中
//        s3.intern();
        String s4="aa";
        System.out.println(s3==s4);
    }
}
