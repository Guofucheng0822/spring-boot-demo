package com.pers.guofucheng.jdk8;

import java.util.function.Function;

/**
 * Funcation演示
 *
 * @author guofucheng
 * @date 2020/11/12
 */
public class FuncationDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> times2 = i -> i*2;
        Function<Integer, Integer> squared = i -> i*i;

        System.out.println(times2.apply(4));
        System.out.println(squared.apply(4));

        //先4×4然后16×2,先执行apply(4)，在times2的apply(16),先执行参数，再执行调用者。
        //TODO compose-先执行被调用调用者，再执行调用者
        // 1.先执行squared.apply(4)=4*4=16
        // 2.再执行times2.apply(16)=2*16=32
        System.out.println(times2.compose(squared).apply(4));  //32
        //先4×2,然后8×8,先执行times2的函数，在执行squared的函数。
        //TODO andThen-按顺序执行，先执行调用者，再执行被调用者
        // 1.先执行time2.apply(4)=4*2=8
        // 2.再执行squared.apply(8)=8*8=64
        System.out.println(times2.andThen(squared).apply(4));  //64
        //TODO Function.identity()返回当前正在执行的方法
        // 1.实例化当前正在执行的方法
        // 2.执行squared.apply(4)=4*4=16
        System.out.println(Function.identity().compose(squared).apply(4));   //16
    }
}
