package com.pers.guofucheng.decoratorPattern;

/**
 * 圆
 *
 * @author guofucheng
 * @date 2020/08/18
 */
public class Circle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Shape: Circle");
   }
}
