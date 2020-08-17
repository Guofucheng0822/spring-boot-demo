package com.pers.guofucheng.bridgePattern;

/**
 * 桥接类
 *
 * @author guofucheng
 * @date 2020/08/12
 */
public abstract class Shape {
   protected DrawAPI drawAPI;
   protected Shape(DrawAPI drawAPI){
      this.drawAPI = drawAPI;
   }

   /**
    * 画
    */
   public abstract void draw();
}