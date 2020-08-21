package com.pers.guofucheng.decoratorPattern;

/**
 * 形状装饰
 *
 * @author guofucheng
 * @date 2020/08/18
 */
public abstract class ShapeDecorator implements Shape {
   protected Shape decoratedShape;
 
   public ShapeDecorator(Shape decoratedShape){
      this.decoratedShape = decoratedShape;
   }

   @Override
   public void draw(){
      decoratedShape.draw();
   }  
}
