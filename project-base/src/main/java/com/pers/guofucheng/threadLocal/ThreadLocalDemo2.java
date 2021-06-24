package com.pers.guofucheng.threadLocal;

import java.lang.ref.WeakReference;

public class ThreadLocalDemo2 {
    public static void main(String[] args) {
        Object angela = new Object();
        //弱引用
        WeakReference<Object> weakReference = new WeakReference<>(angela);
        //angela和弱引用指向同一个对象
        System.out.println(angela);//java.lang.Object@4550017c
        System.out.println(weakReference.get());//java.lang.Object@4550017c
        //将强引用angela置为null，这个对象就只剩下弱引用了,内存够用，弱引用也会被回收
        angela = null;
        System.gc();//内存够用不会自动gc，手动唤醒gc
        System.out.println(angela);//null
        System.out.println(weakReference.get());//null
    }
}
