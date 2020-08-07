package com.pers.guofucheng.abstractFactoryPattern;

/**
 * 生产工厂的创造器
 *
 *创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
 * @author guofucheng
 * @date 2020/06/29
 */
public class FactoryProducer {

   public static AbstractFactory getFactory(String choice){
      if(choice.equalsIgnoreCase("SHAPE")){
         return new ShapeFactory();
      } else if(choice.equalsIgnoreCase("COLOR")){
          //TODO 以下逻辑如同获取形状工厂逻辑
//         return new ColorFactory();
      }
      return null;
   }
}