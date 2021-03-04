package com.pers.guofucheng.arraylist;

import org.junit.Test;

import java.util.Vector;

/**
 * Vector测试
 *
 * @author guofucheng
 * @date 2021/03/03
 */
public class VectorTest {

    public static Vector vector = new Vector();

    public static void main(String[] args) {
//        test1();
        test2();
    }

//    @Test
    public static void test1() {
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(Thread.currentThread().getName()+":"+vector.get(i));
            vector.remove(i);
            i--;
        }
    }

//    @Test
    public static void test2() {
        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Thread.yield();// 使当前线程由执行状态，变成为就绪状态，让出cpu时间，在下一个线程执行时候，此线程有可能被执行，也有可能没有被执行。
                        test1();
                    }
                },"aaa"
        );

        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Thread.yield(); // 使当前线程由执行状态，变成为就绪状态，让出cpu时间，在下一个线程执行时候，此线程有可能被执行，也有可能没有被执行。
                        test1();
                    }
                },"bbb"
        );
        thread1.start();
        thread2.start();
    }
}
