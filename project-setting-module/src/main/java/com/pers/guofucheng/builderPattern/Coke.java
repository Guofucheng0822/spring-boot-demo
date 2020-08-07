package com.pers.guofucheng.builderPattern;

public class Coke extends ColdDrink {
 
   @Override
   public float price() {
      return 30.0f;
   }
 
   @Override
   public String name() {
      return "可乐";
   }
}