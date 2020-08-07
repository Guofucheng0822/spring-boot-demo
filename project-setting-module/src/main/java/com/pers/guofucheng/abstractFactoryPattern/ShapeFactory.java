package com.pers.guofucheng.abstractFactoryPattern;

/**
 * 形状的工厂[]
 *
 * 创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。
 *
 * @author guofucheng
 * @date 2020/06/29
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
    //TODO ColorFactory 中实现该逻辑,如同实现getShape逻辑
//
//    @Override
//    public Color getColor(String color) {
//        return null;
//    }
}