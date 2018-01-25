package com.wzj.innerclass.thread;

/**
 * 2.8.	运行中在对象等待池中阻塞
 *	当一个线程获取到一个资源的同步锁，
 *	但他发现自己当前的运行条件还不满足时，他不能一直占用该资源。
 *	这时候他应该放弃该资源的锁，让其他条件满足的线程去获取该资源并执行。
 *	这时通过调用该资源的wait方法放弃该锁。进入对象等待池中阻塞
 *
 * @author WLF
 *
 */
public class WaitThread {
	public static void main(String[] args) {
		WaitThread wt = new WaitThread();
		People p1 = new People("p1","");
		People p2 = new People("p2",null);
		People p3 = new People("p3","我的简历");
		A a1 = wt.new A(p1);
		A a2 = wt.new A(p2);
		A a3 = wt.new A(p3);
		a1.start();
		a2.start();
		a3.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a2.interrupt();
		a1.interrupt();

	}	
	class A extends Thread{
		/**面试人*/
		private People people;
		public A(People people){
			this.people = people;
		}
		@Override
		public void run() {
			System.out.println(this.people.getName()+"准备面试");
			while(true) {
				synchronized (WaitThread.class) {
					System.out.println(this.people.getName()+"可以面试");
					if(this.people.getJianli()==null){
						try {
							System.out.println("忘记带简历!通知下一个人先进去！");
							//调用该资源的wait方法放弃该锁
							WaitThread.class.wait();
							System.out.println(this.people.getName()+"重新获取资源");
							continue;
						} catch (InterruptedException e) {
							e.printStackTrace();
								}
					}else if(this.people.getJianli().equals("")){
						try {
							System.out.println("简历还没写完 通知下一个人先进去！");
							WaitThread.class.wait();
							System.out.println(this.people.getName()+"重新获取资源");
							continue;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("面试完毕！");
					WaitThread.class.notifyAll();
					break;
				}
			}
		}
	}
}

	class People{
		private String name;
		private String jianli;
		public People(){}
		public People(String name ,String jianli){
			this.name = name;
			this.jianli = jianli;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getJianli() {
			return jianli;
		}
		public void setJianli(String jianli) {
			this.jianli = jianli;
		}
	}
