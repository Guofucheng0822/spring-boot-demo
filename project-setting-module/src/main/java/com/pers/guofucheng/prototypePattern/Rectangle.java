package com.pers.guofucheng.prototypePattern;

public class Rectangle extends Shape {
 
   public Rectangle(){
     type = "长方形";
   }
 
   @Override
   public void draw() {
      System.out.println("长方形执行的方法!");
   }
}