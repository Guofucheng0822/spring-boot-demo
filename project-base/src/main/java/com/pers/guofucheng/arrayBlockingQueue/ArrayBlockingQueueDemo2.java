package com.pers.guofucheng.arrayBlockingQueue;

import java.util.concurrent.*;

/**
 * ArrayBlockingQueue的线程池模式
 *  基于ArrayBlockingQueue的生产者消费者模式  put和take都是阻塞操作
 * @author guofucheng
 * @date 2020/04/30
 */
public class ArrayBlockingQueueDemo2 {
    private static BlockingQueue queue = new ArrayBlockingQueue(3);
    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), threadFactory);

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
                            System.out.println(Thread.currentThread().getName() + "准备放数据！");
                            queue.put(1);
                            System.out.println(Thread.currentThread().getName() + "已经放了数据,目前队列存在" + queue.size() + "个数据");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

        }


        executor.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(5000L);
                        System.out.println(Thread.currentThread().getName() + "准备取数据。。。");
                        queue.take();
                        System.out.println(Thread.currentThread().getName() + "已经取完数据,目前队列里面还有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });


    }
}
