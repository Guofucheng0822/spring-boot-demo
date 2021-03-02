package com.pers.guofucheng.test;

/**
 * 不会发生逃逸
 *
 * @author guofucheng
 * @date 2021/03/02
 */
public class PartionOnStack2 {
    class User {
        public int id;
        public String name;
    }

    public void foo() {
        User user = new User();
        user.id = 1;
        user.name = "sixtrees";
    }

    public static void main(String[] args) {
        System.out.println("start-----------");
        long beginTime = System.currentTimeMillis();
        PartionOnStack2 pos = new PartionOnStack2();
        for (int i = 0; i < 100000000; i++) {
            pos.foo();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总共运行----" + (endTime - beginTime) + "ms");
    }

}