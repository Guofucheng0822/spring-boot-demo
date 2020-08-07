package com.pers.guofucheng.abstractFactoryPattern;

/**
 * [抽象工厂模式需要的依赖]
 * 工厂模式[https://www.runoob.com/design-pattern/factory-pattern.html]
 *
 * 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。
 * 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 *
 * 在工厂模式中，
 * 我们在创建对象时不会对客户端暴露创建逻辑，
 * 并且是通过使用一个共同的接口来指向新创建的对象。
 *
 * @author guofucheng
 * @date 2020/06/29
 */
public class FactoryPatternDemo {

    /**
     * 测试方法
     *
     * @param args args
     */
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();
        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        //调用 Rectangle 的 draw 方法
        shape2.draw();
        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");
        //调用 Square 的 draw 方法
        shape3.draw();
    }
}

/**
 * 公共接口-形状
 *
 * @author guofucheng
 * @date 2020/06/29
 */
interface Shape {
    /**
     * 公共方法-画
     */
    void draw();
}

/**
 * 实现类1:矩形
 *
 * @author guofucheng
 * @date 2020/06/29
 */
class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("创建一个矩形对象");
    }
}

/**
 * 实现类2:正方形
 *
 * @author guofucheng
 * @date 2020/06/29
 */
class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("创建一个正方形对象");
    }
}

/**
 * 实现类2:圆形
 *
 * @author guofucheng
 * @date 2020/06/29
 */
class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("创建一个圆形对象");
    }
}

