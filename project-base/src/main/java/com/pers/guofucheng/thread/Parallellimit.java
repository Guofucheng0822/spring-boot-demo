package com.pers.guofucheng.thread;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch研究分析
 *
 * @author guofucheng
 * @date 2021/03/25
 */
public class Parallellimit {
    List list;
    public static void main(String[] args) {

        Parallellimit parallellimit=new Parallellimit();
        List list=new ArrayList();
        parallellimit.setList(list);
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Object[] array=new Object[100];
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            pool.execute(() -> {
                List list1=new ArrayList();
                list1.add(finalI);
                array[finalI]=list1;
                if (finalI>90){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parallellimit.setList(Arrays.asList(array));
        System.out.println(JSON.toJSONString(parallellimit));
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}