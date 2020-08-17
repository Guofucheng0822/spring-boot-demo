package com.pers.guofucheng.bridgePattern;

/**
 * 红色圆圈
 *
 * @author guofucheng
 * @date 2020/08/12
 */
public class RedCircle implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: red, radius: "
         + radius +", x: " +x+", "+ y +"]");
   }
}