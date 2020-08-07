package com.pers.guofucheng;

import com.pers.guofucheng.chouxianglei.BaseCxl;
import com.pers.guofucheng.jicheng.Fu;
import com.pers.guofucheng.jicheng.Zi;
import org.junit.Test;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public class TestBase {

    @Test
    public void testJicheng(){
        Fu fu=new Zi();
        System.out.println(fu.name);
        fu.eat();
        BaseCxl baseCxl=new BaseCxl() {
            @Override
            public String eat() {
                return "hhhhhhhh";
            }
        };
        System.out.println(baseCxl.eat());
        String hh = baseCxl.hh();
        System.out.println(hh);
    }

    public static void main(String[] args) {
        double sqrt = sqrt(45);
        double sqrt1 = Math.sqrt(10.1);
        System.out.println(sqrt);
        System.out.println(sqrt1);
    }

    private static double sqrt(double x) {
        double g=x;
        while(Math.abs(g*g-x)>0.000001)
        {
            g=(g+x/g)/2;
        }
        return g;
    }

}
