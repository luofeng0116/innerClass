package com.wzj.innerclass.thread;

/**
 * 2.11.	运行中完结状态
 * 运行中状态变为完结状态有2个途径：正常运行结束。
 * 比如break return人为的结束线程：修改线程运行标识s
 * @author WLF
 *
 */
public class CloseThread {
	class B extends Thread{
		public volatile boolean isRun=true;
		@Override
		public void run() {
			while(isRun) {
				System.out.println("揍你");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		CloseThread c1=new CloseThread();
		B b=c1.new B(); 
		b.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		b.isRun=false;
		System.out.println("停止");

	}
}
