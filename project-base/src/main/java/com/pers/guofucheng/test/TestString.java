package com.pers.guofucheng.test;

public class TestString {
    public static String test1(String s,int[] indices) {

    	char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
    	return new String(chars);
    }

    public static void main(String[] args) {
        int[] aaa={0,1,2,3,4};
        System.out.println(test1("bcade",aaa));
    }
}