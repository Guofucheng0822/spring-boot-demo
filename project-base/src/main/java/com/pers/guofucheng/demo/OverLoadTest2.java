package com.pers.guofucheng.demo;

/**
 * 重载测试2
 *
 * @author guofucheng
 * @date 2021/04/09
 */
public class OverLoadTest2 {

    public void invoke(Object object, Object... arges) {
        System.out.println("==============invoke111==============");
    }

    public void invoke(String string, Object object,Object... arges) {
        System.out.println("==============invoke222==============");
    }

    public static void main(String[] args) {
        OverLoadTest2 overLoadTest2 = new OverLoadTest2();
        overLoadTest2.invoke(null,1);
//        overLoadTest2.invoke(null,1,2);
//        overLoadTest2.invoke(null,new Object[] {null});
    }
}
