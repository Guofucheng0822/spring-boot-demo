package com.pers.guofucheng.settingMode;

/**
 * 工厂模式(Factory)
 *
 * @author guofucheng
 * @date 2020/06/11
 */

import com.sun.istack.internal.NotNull;

/**
 * 第一种:
 * 实例1：追MM少不了请吃饭了，
 * 麦当劳的鸡翅和肯德基的鸡翅都是MM爱吃的东西，
 * 虽然口味有所不同，但不管你带MM去麦当劳或肯德基，
 * 只管向服务员说“来四个鸡翅”就行了。
 * 麦当劳和肯德基就是生产鸡翅的Factory 。
 * ------------------------------------------------------------------------------------------------
 */
class Factory1{
    /**
     * 吃
     *
     * @param num
     */
    public static void eat(@NotNull int num){
        if (num==1){
            System.out.println("工厂生产A对象");
        }
        if (num==2){
            System.out.println("工厂生产B对象");
        }
    }
}





/**
 *实例2：请MM去麦当劳吃汉堡，不同的MM有不同的口味，
 * 要每个都记住是一件烦人的事情，
 * 我一般采用Factory Method模式，带着MM到服务员那儿，
 * 说“要一个汉堡”，具体要什么样的汉堡呢，让MM直接跟服务员说就行了。
 * ------------------------------------------------------------------------------------------------
 */
 abstract class AbstractFactory2 {
    /**
     * 吃
     */
    abstract void eat();
}

class AFactory extends AbstractFactory2 {
    @Override
    void eat() {
        System.out.println("A工厂生产的对象");
        ;
    }
}

class BFactory extends AbstractFactory2 {
    @Override
    void eat() {
        System.out.println("B工厂生产的对象");
        ;
    }
}

class FactoryTest {
    public static void main(String[] args) {
        //-----------第一种------------------------
        Factory1.eat(1);
        //-----------第二种------------------------
        AFactory aFactory=new AFactory();
        aFactory.eat();
    }
}