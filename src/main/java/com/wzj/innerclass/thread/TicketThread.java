package com.wzj.innerclass.thread;

/**
 * 2.7.	运行中在对象锁池中阻塞
 * 因为同一个进程中的线程是共享进程中的相同资源，
 * 随之就会出现线程的同步的问题。
 * 线程的同步的问题：共享资源访问的冲突问题，线程数据安全的问题。
 * @author WLF
 *
 */
public class TicketThread {
	private Integer ticketCount = 10;
	
	/*
	 * public void tset() {
	 *		synchronized(this) {
	 *		System.out.println("test........");
	 *		}
	 *}
	 */
	 
	public synchronized void tset() {
		System.out.println("test........");
	}
	
	/**
	 * synchronized关键字还可以用来修饰方法,他只能同步当前类的对象，
	 * 相当于synchronized（this）,
	 * 如果方法添加了static关键字，则表示同步当前类,
	 * 相当于synchronized(****.class)
	 */
	public synchronized static void test2() {
		System.out.println("test2........");
	}
	class Test extends Thread{

		@Override
		public void run() {
			//TicketThread.this.tset();
			TicketThread.test2();
		}
		
	}
	
	class Sell extends Thread{
		private String name;
		private int sleepTime;
		
		public Sell(String name, int sleepTime) {
		
			this.name = name;
			this.sleepTime = sleepTime;
		}

		@Override
		public void run() {
			while (true) {
				System.out.println("。。。。。。");
				/**
				 * 在java中每个对象都有一把同步锁，
				 * 而能打开这把锁的钥匙也只有一把。
				 * 我们为总票数进行加锁就能解决。
				 * Java中的synchronized表示同步标记
				 */
				synchronized(TicketThread.class) {
					if(ticketCount>0){
						try {
							Thread.sleep(sleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(this.name+"售出票"+ticketCount);
						ticketCount=ticketCount-1;
					}else {
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TicketThread t1=new TicketThread();
		TicketThread t2=new TicketThread();
		t1.new Test().start();
		t2.new Test().start();
		System.out.println("====================");
		Sell s1=t1.new Sell("s1",10);
		Sell s2=t1.new Sell("s2",0);
		s1.start();
		s2.start();
	}
}
