package com.pers.guofucheng.test;

/**
 * 栈上分配
 *
 * @author guofucheng
 * @date 2021/03/02
 */
public class PartionOnStack {
   static class User{
    private int id;
    private String name;
    public User(){}
       }
    private static  User user;
    public static void foo() {
    user=new User();
    user.id=1;
    user.name="sixtrees";
    }
    public static void main(String[] args) {
    foo();
    }
 
}