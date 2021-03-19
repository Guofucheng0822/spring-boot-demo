package com.pers.guofucheng.demo;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：如何快速查找到一个单链表的中间位置？
 * 快慢指针首先指向第一个节点，快指针每次走2个结点，慢指针每次走1个结点，当快指针走完链表，慢指针刚好走到中间。
 * 当前快指针走完链表时，慢指针刚好走到 中间结点。
 * 实际上当结点数是奇数时 慢指针走到中间结点，
 * 当结点数是偶数时，此时中间结点有2个，此时慢指针指向靠前那个结点。
 * 举个例子:
 * 1 3 5 7 9 快指针第一次走到 5 第二次走到 9 然后链表走完，慢指针走2步 刚好走到 中间结点5
 * 1 3 5 7   快指针第一次走到 5 第二次越界只走一步然后链表走完，快指针走2步慢指针走1步，快指针走1步时慢指针没有走，故慢指针 走到结点 3。
 * 如果想 当结点个数为偶数个时，慢指针指向 中间2个结点靠后那个结点，那么当快指针走1步时，慢指针也走1步。
 *
 * @author guofucheng
 * @date 2021/03/19
 */
public class FastQueryLinkedList {

    /**
     * 在链表中很多题目的解法都跟大小指针有关。
     * 比如这道题目，设立两个指针，一个单步走，一个两步走，
     * 当大步指针到达链表尾部的时候，小步指针也正好位于链表中间位置。算法实现如下：
     */
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        System.out.println("中间的节点是:"+queryMiddleElement(linkedList));;

    }

    public static Integer queryMiddleElement(LinkedList<?> linkedList) {
        Integer num1 = null;
        Integer num2 = null;
        for (int i = 0; i * 2 < linkedList.size(); i++) {
            //慢指针
            num1 = (Integer) linkedList.get(i);
            //二倍指针
            num2 = (Integer) linkedList.get(i * 2);
        }
        return num1;
    }

}