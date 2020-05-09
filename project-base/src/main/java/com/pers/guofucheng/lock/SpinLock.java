package com.pers.guofucheng.lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    private AtomicReference cas = new AtomicReference();

    public void lock() {
        Thread current = Thread.currentThread();
        // 利用CAS
        while (!cas.compareAndSet(null, current)) {
            System.out.println("使用锁");
        // DO nothing

        }

    }

    public void unlock() {

        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
        System.out.println("释放锁");

    }

    public static void main(String[] args) {
        SpinLock spinLock =new SpinLock();
        spinLock.lock();
        System.out.println("gggg");
        spinLock.unlock();
    }
}
