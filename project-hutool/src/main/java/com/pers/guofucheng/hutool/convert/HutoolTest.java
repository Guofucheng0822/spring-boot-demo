package com.pers.guofucheng.hutool.convert;

import cn.hutool.core.convert.Convert;
import com.pers.guofucheng.hutool.po.Goods;
import com.pers.guofucheng.hutool.po.Persion;

/**
 * Hutool测试
 *
 * @author guofucheng
 * @date 2020/08/17
 */
public class HutoolTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("------------Hutool--------------------------");
        int a = 1;
        //aStr为"1"
        String aStr = Convert.toStr(a);
        System.out.println(aStr);
        long[] b = {1, 2, 3, 4, 5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        System.out.println(bStr);
        System.out.println("------------jdk--------------------------");
    }
}
