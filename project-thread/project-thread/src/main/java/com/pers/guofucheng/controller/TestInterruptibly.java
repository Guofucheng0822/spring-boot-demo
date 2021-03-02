package com.pers.guofucheng.controller;

import org.junit.Test;

public class TestInterruptibly {
 
	@Test
	public void testInterruptibly() throws Exception{
		
		BussinessClass bc=new BussinessClass();
		//线程1
		Thread t0= new Thread(() -> bc.bFuction());
		//线程2
		Thread t1= new Thread(() -> bc.bFuction());
		
		String tName=Thread.currentThread().getName();
		
		System.out.println(tName+"-启动t0！");
		t0.start();
		System.out.println(tName+"-我等个5秒，再启动t1");
		Thread.sleep(5000);
		System.out.println(tName+"-启动t1");
		t1.start();
		
		System.out.println(tName+"-t1获取不到锁，t0这货睡觉了，没释放，我等个5秒！");
		Thread.sleep(5000);
		System.out.println(tName+"-等了5秒了，不等了，把t1中断了！");
		t1.interrupt();
		
		Thread.sleep(Long.MAX_VALUE);
	}
	
	
}
