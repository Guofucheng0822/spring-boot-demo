package com.pers.guofucheng.arrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingTest {
    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(2);
        // 阻塞
//        try {
//            arrayBlockingQueue.put(11);
//            arrayBlockingQueue.put(11);
//            arrayBlockingQueue.put(11);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // Exception in thread "main" java.lang.IllegalStateException: Queue full
        arrayBlockingQueue.add(11);
        arrayBlockingQueue.add(11);
        arrayBlockingQueue.add(11);
    }
}
