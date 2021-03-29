package com.pers.guofucheng.thread;

/**
 * 编写两个线程，交替打印斐波拉契数列。
 *
 * @author guofucheng
 * @date 2021/03/29
 */
public class NumPrinterDemo2 {

    private final Object monitor = new Object();
    private final int limit;
    private volatile int count;

    public NumPrinterDemo2(int limit, int initCount) {
        this.limit = limit;
        this.count = initCount;
    }

    public void print() {
        synchronized (monitor) {
            while (count < limit) {
                try {
                    System.out.println(String.format("线程[%s]打印数字:%d", Thread.currentThread().getName(), ++count));
                    monitor.notifyAll();
                    monitor.wait();
                } catch (InterruptedException e) {
                    //ignore
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        NumPrinterDemo2 numPrinterDemo = new NumPrinterDemo2(10, 0);
        Thread thread1 = new Thread(() -> numPrinterDemo.print(), "thread-1");
        Thread thread2 = new Thread(() -> numPrinterDemo.print(), "thread-2");
        thread1.start();
        thread2.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
