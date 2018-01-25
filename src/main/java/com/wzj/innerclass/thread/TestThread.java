package com.wzj.innerclass.thread;

public class TestThread {
	public static void main(String[] args) {
		//创建线程对象
		Thread t1 = new Thread1();
		Thread t2 =new Thread(new Runner());
		//调用线程的statr()方法进入可运行状态
		t1.start();
		t2.start();
	}
}
