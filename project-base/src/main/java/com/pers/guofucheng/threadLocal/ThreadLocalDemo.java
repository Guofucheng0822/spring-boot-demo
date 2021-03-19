package com.pers.guofucheng.threadLocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * ThreadLocalDemo
 * 经典文章：https://www.cnblogs.com/jiangxinlingdu/p/11055540.html
 * @author guofucheng
 * @date 2021/03/19
 */
public class ThreadLocalDemo {
    /*定义了1个ThreadLocal<Integer>对象，
     *并复写它的initialValue方法，初始值是3*/
    private ThreadLocal<Integer> tlA = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 3;
        }
    };

    /*设置一个信号量，许可数为1，让三个线程顺序执行*/
    Semaphore semaphore = new Semaphore(1);

    private Random rnd = new Random();

    /*Worker定义为内部类实现了Runnable接口,tlA定义在外部类中，
每个线程中调用这个对象的get方法，再调用一个set方法设置一个随机值*/
    public class Worker implements Runnable {
        @Override
        public void run() {

            try {
                Thread.sleep(rnd.nextInt(1000)); /*随机延时1s以内的时间*/
                semaphore.acquire();/*获取许可*/
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int valA = tlA.get();
            System.out.println(Thread.currentThread().getName() + " tlA initial val : " + valA);
            valA = rnd.nextInt();
            tlA.set(valA);
            System.out.println(Thread.currentThread().getName() + " tlA  new     val: " + valA);


            semaphore.release();

            /*在线程池中,当线程退出之前一定要记得调用remove方法，因为在线程池中的线程对象是循环使用的*/
            tlA.remove();
        }
    }

    /*创建三个线程，每个线程都会对ThreadLocal对象tlA进行操作*/
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        ThreadLocalDemo tld = new ThreadLocalDemo();
        es.execute(tld.new Worker());
        es.execute(tld.new Worker());
        es.execute(tld.new Worker());
        es.shutdown();
    }
}