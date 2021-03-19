package com.pers.guofucheng.demo;

/**
 * 用数组实现队列
 *
 * @author stan
 */
public class ArrayQueue {
    /**
     * 数组items
     */
    private String[] items;
    /**
     * 数组大小 n
     */
    private int n = 0;
    /**
     * 数组头下标
     */
    private int head = 0;
    /**
     * 数组尾下标
     */
    private int tail = 0;

    /**
     * 提供构造 指定大小长度的队列
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        //队列已经满了
        if (tail == n) {
            if (head == 0) {
                return false;
            }
//  数据迁移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
//  迁移完后重新计算head和tail
            tail -= head;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        return items[head++];
    }
}
