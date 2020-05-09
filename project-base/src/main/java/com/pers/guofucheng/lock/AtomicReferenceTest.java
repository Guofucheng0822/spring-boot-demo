package com.pers.guofucheng.lock;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static void main(String[] args) {
        AtomicReference cas = new AtomicReference();
        boolean b = cas.compareAndSet(1, 1);
        System.out.println(b);
    }
}
