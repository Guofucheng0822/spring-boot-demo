package com.pers.guofucheng.arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ArrayList测试
 *
 * @author guofucheng
 * @date 2021/03/02
 */
public class ArrayListTest {
    class User {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @Test
    public void test1() {
        String str = "";
        int i = 0;
        User user = null;
        setDate(str, i, user);
        System.out.println("str:" + str);
        System.out.println("i:" + i);
        System.out.println("user:" + user);
    }

    public void test2() {
        //this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA; 构建一个初始化容量为10的空数组
        List list1 = new ArrayList();
        // this.elementData = new Object[initialCapacity]; 构建一个指定长度的Object []
        // this.elementData = EMPTY_ELEMENTDATA; 如果是0，构建一个空数组
        List list2 = new ArrayList(10);
        //transient Object[] elementData; 实际存储数据的数组
        ArrayList list3 = new ArrayList(list2);
        //1.底层使用数组的原因是：下标查询、连续内存、存储的对象类型相同
        //2.get(i) = 数组的起始位置 + i * 元素占用的内存；时间复杂度为 O(1)\
        list3.add(1);
    }
    @Test
    public void test3(){
        //8的二进制1000，右移一位100
        int a=20 >> 1;
        System.out.println(a);
        ArrayList list=new ArrayList();
        list.add(1);
    }

    @Test
    public void test4(){
        int[] array={1,2,3,4,5};
        List ints = Arrays.asList(array);
        // 1.基本类型不支持泛型化
        // 2.数组不支持向下转型(自动拆箱装箱)
        // 3.没有add方法
        System.out.println(ints.size());
        //==========================================================================================
        System.out.println("=====================================================");
        Integer[] arrayInteger={1,2,3,4,5};
        List<Integer> list = Arrays.asList(arrayInteger);
        System.out.println(list.size());
    }

    @Test
    public void test5(){
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> unmodifiableList = Collections.unmodifiableList(list);
        // UnsupportedOperationException不允许改变
        // unmodifiableList.add(1);
        list.add(77);
        System.out.println(unmodifiableList);
    }


    private void setDate(String str, int i, User user) {
        str = "str";
        i = 10;
        user = new User();
        user.setName("name");
        user.setAge(1000);
    }
}

