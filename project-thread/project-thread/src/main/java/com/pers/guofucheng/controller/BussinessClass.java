package com.pers.guofucheng.controller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
public class BussinessClass {
	
	private Lock lock = new ReentrantLock();
 
	// 业务方法
	public void bFuction() {
		String tName = Thread.currentThread().getName();
		try {
			System.out.println(tName + "-开始获取锁..........");
			lock.lockInterruptibly();
 
			System.out.println(tName + "-获取到锁了！！！！");
			System.out.println(tName + "-睡觉了，睡个30秒！");
			Thread.sleep(30000);
			System.out.println(tName + "-睡醒了，干活！");
			for (int i = 0; i < 5; i++) {
				System.out.println(tName + "：" + i);
			}
		} catch (Exception e) {
			System.out.println(tName+"-我好像被中断了！");
			e.printStackTrace();
		}finally{
			lock.unlock();
			System.out.println(tName + "-释放了锁");
		}
	}
	
}
