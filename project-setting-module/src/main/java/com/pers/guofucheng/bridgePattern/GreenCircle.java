package com.pers.guofucheng.bridgePattern;

/**
 * 绿色圆圈
 *
 * @author guofucheng
 * @date 2020/08/12
 */
public class GreenCircle implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: green, radius: "
         + radius +", x: " +x+", "+ y +"]");
   }
}