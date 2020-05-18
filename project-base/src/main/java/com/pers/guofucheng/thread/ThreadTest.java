package com.pers.guofucheng.thread;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public class ThreadTest {
    public static void main(String[] args) {
//        Thread myThread1=new MyThread("Thread-1");
//        Thread myThread2=new MyThread("Thread-2");
//        myThread1.start();
//        myThread2.start();
        Ticket ticket = new Ticket();
        Thread thread1=new Thread(ticket,"线程1");
        Thread thread2=new Thread(ticket,"线程2");
        Thread thread3=new Thread(ticket,"线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
