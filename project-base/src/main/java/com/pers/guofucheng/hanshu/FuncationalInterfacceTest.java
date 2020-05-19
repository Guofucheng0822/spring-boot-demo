package com.pers.guofucheng.hanshu;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public class FuncationalInterfacceTest {
//     使用自定义的函数式接口作为方法参数     
    private static void doSomething(MyFunctionalInterface inter){
        inter.eat();
    }

    public static void main(String[] args) {
        doSomething(new MyFunctionalInterface() {
            @Override
            public void eat() {
                System.out.println("匿名内部类方式调用");
            }
        });
        doSomething(()-> System.out.println("Lambda表达式方式调用"));
    }
}
