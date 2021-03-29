package com.pers.guofucheng.thread;

/**
 * 编写两个线程，交替打印斐波拉契数列。
 *
 * @author guofucheng
 * @date 2021/03/29
 */
public class NumPrinterDemo {

    private final Object monitor = new Object();

    /**
     * 值
     */
    private volatile int num;

    public NumPrinterDemo(int num) {
        this.num = num;
    }

    public void print() {
        synchronized (monitor) {
            while (true) {
                try {
                    System.out.println(String.format("线程[%s]:%d", Thread.currentThread().getName(), ++num));
                    monitor.notifyAll();
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        NumPrinterDemo numPrinterDemo = new NumPrinterDemo(0);
        Thread thread1 = new Thread(() -> numPrinterDemo.print(), "thread-1");
        Thread thread2 = new Thread(() -> numPrinterDemo.print(), "thread-2");
        thread1.start();
        thread2.start();
    }
}
