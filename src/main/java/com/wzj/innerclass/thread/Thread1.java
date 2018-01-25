package com.wzj.innerclass.thread;

/**
 * 创建线程体
 * @author WLF
 *
 */
public class Thread1 extends Thread{

	@Override
	
	
	/*public void run() {
		System.out.println("进去");
		
		*//**
		 * yield暂停当前正在执行的线程对象，并执行其他线程
		 * yield方法的真正含义是强迫当前获取时间片的线程放弃时间片的占用，
		 * 返回到可运行状态重新参与时间片的竞争
		 *//*
		Thread.yield();
		System.out.println("退出");
		System.out.println("Thread1");
	}*/
	
	public void run() {
		System.out.println("开始执行");
		
	}
	
	
	
}
