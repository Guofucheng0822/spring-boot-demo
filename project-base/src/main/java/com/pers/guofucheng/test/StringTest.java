package com.pers.guofucheng.test;

public class StringTest {
    public static void main(String[] args) {
        String str1="hello";
        String str2="hello";
        String str3=new String("hello");
        String str4=new String("hello");
        System.out.println(str1==str3);
        System.out.println(str3==str4);
    }
}
