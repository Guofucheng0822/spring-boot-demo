package com.pers.guofucheng.prototypePattern;

public class Square extends Shape {
 
   public Square(){
     type = "正方形";
   }
 
   @Override
   public void draw() {
      System.out.println("正方形执行的方法!");
   }
}