package com.pers.guofucheng.arrayBlockingQueue;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * ArrayBlockingQueue的普通线程操作模式
 *  基于ArrayBlockingQueue的生产者消费者模式  put和take都是阻塞操作
 * @author guofucheng
 * @date 2020/04/30
 */
public class ArrayBlockingQueueDemo1 {
    public static void main(String[] args) {
        final BlockingQueue queue = new ArrayBlockingQueue(3);
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep((long) (Math.random() * 100));
                            System.out.println(Thread.currentThread().getName() + "准备放数据!");
                            queue.put(1);
                            System.out.println(Thread.currentThread().getName() + "已经放了数据，" +
                                    "队列目前有" + queue.size() + "个数据");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }.start();
        }

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        //将此处的睡眠时间分别改为100和1000，观察运行结果
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "准备取数据!");
                        queue.take();
                        System.out.println(Thread.currentThread().getName() + "已经取走数据，" +
                                "队列目前有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }.start();
    }

    @Test
    public void test1(){
        System.out.println(Math.random());
    }
}
