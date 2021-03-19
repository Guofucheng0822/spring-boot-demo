package com.pers.guofucheng.atomic;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger测试
 * <p>
 * AtomicInteger 类常用方法：
 * <p>
 * public final int get() //获取当前的值
 * public final int getAndSet(int newValue)//获取当前的值，并设置新的值
 * public final int getAndIncrement()//获取当前的值，并自增
 * public final int getAndDecrement() //获取当前的值，并自减
 * public final int getAndAdd(int delta) //获取当前的值，并加上预期的值
 * boolean compareAndSet(int expect, int update) //如果输入的数值等于预期值，则以原子方式将该值设置为输入值（update）
 * public final void lazySet(int newValue)//最终设置为newValue,使用 lazySet 设置之后可能
 * ————————————————
 *
 * @author guofucheng
 * @date 2021/03/16
 */
public class AtomicIntegerTest {
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int temvalue = 0;
        AtomicInteger i = new AtomicInteger(0);
        temvalue = i.getAndSet(3);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:0;  i:3
        temvalue = i.getAndIncrement();
        System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:3;  i:4
        temvalue = i.getAndAdd(5);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:4;  i:9
        boolean b = i.compareAndSet(9, 1);
        System.out.println("b:"+b + ";  i:" + i);
    }

}