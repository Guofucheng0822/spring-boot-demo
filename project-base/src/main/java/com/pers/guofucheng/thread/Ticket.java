package com.pers.guofucheng.thread;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public class Ticket implements Runnable {
    private Integer ticket = 100;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sellTicket();
        }
    }
    public  synchronized void sellTicket() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + ":当前剩余票数量:" + ticket--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
