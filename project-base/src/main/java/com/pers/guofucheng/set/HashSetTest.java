package com.pers.guofucheng.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public class HashSetTest {
    public static void main(String[] args) {
        final Set<Integer> set = new HashSet();// 结果可能大于1000
//        final Set<Integer> set = Collections.synchronizedSet(new HashSet<>());// 结果等于1000
//        final Set<Integer> set = Collections.newSetFromMap(new ConcurrentHashMap<Integer, Boolean>());// 结果等于1000

        // 往set写入1-1000
        Runnable runnable = () -> {
            for (int i = 1; i <= 1000; i++) {
                set.add(i);
            }
        };

        int threadNum = 10;// 线程数
        List<Thread> threadList = new ArrayList();
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(runnable);
            threadList.add(thread);
            thread.start();
        }

        // 主线程等待子线程执行完成
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(set.size());// 结果可能大于1000
    }
}
