package com.pers.guofucheng.decoratorPattern;

/**
 * 矩形
 *
 * @author guofucheng
 * @date 2020/08/18
 */
public class Rectangle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Shape: Rectangle");
   }
}
