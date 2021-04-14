package com.pers.guofucheng.demo;

/**
 * 重载测试1
 *
 * 方法传入null，重载的两个方法都可以接受调用，
 * 但只能调用一个，会选择一个相对合适的方法，
 * 因为任何传递给string参数都可以传递给object，
 * 反之不行，所以string参数的方法更加合适，会被调用，
 * 如果再加一个重载函数传入一个例如Integer，编译器会报错方法有歧义
 *
 * @author guofucheng
 * @date 2021/04/09
 */
public class OverLoadTest1 {

    public Object sayHello(Object a){
        System.out.println("==============Object==============");
        return a;
    }
    public String sayHello(String a){
        System.out.println("==============String==============");
        return a;
    }
//    public Integer sayHello(Integer a){
//        System.out.println(==============Integer==============);
//        return a;
//    }

    public static void main(String[] args) {
        OverLoadTest1 overLoadTest1 = new OverLoadTest1();
        overLoadTest1.sayHello(null);
    }
}
