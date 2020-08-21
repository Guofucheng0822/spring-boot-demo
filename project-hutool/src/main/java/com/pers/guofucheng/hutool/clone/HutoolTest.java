package com.pers.guofucheng.hutool.clone;

import com.pers.guofucheng.hutool.po.Goods;
import com.pers.guofucheng.hutool.po.Persion;

/**
 * Hutool测试 Cloneable接口
 *
 * @author guofucheng
 * @date 2020/08/17
 */
public class HutoolTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("------------Hutool--------------------------");
        Persion persion=new Persion();
        persion.setName("小明");
        persion.setAge(1);
        System.out.println(persion);
        Persion persion1 = persion.clone();
        System.out.println(persion1);
        System.out.println("------------jdk--------------------------");
        Goods goods=new Goods();
        goods.setName("手机");
        goods.setPrice(100.1);
        Goods goods1 = (Goods)goods.clone();
        System.out.println(goods);
        System.out.println(goods1);
    }
}
