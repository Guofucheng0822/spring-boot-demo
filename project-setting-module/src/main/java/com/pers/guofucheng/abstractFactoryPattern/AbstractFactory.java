package com.pers.guofucheng.abstractFactoryPattern;

/**
 * 抽象工厂模式
 *
 * 为 Shape 和[Color:同Shape对象一样创建的工厂模式] 对象创建抽象类来获取工厂
 *
 * @author guofucheng
 * @date 2020/06/29
 */
public abstract class AbstractFactory {

//    public abstract Color getColor(String color);
    /**
     * 得到的形状
     *
     * @param shape 形状
     * @return {@link Shape}
     */
    public abstract Shape getShape(String shape) ;
}