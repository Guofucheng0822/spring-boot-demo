package com.pers.guofucheng.thread;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟线程池异步处理数据，然后按照顺序统一提交
 * CountDownLatch研究分析
 *
 * @author guofucheng
 * @date 2021/03/25
 */
public class CountDownLatchDemo {
    List list;
    public static void main(String[] args) {

        CountDownLatchDemo countDownLatchDemo=new CountDownLatchDemo();
        List list=new ArrayList();
        countDownLatchDemo.setList(list);
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

        countDownLatchDemo.setList(Arrays.asList(array));
        System.out.println(JSON.toJSONString(countDownLatchDemo));
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}