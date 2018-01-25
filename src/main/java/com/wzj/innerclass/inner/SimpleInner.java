package com.wzj.innerclass.inner;

/**
 * 成员内部类和普通成员一样可以被声明为
 * private，public，protected，default，final，abstrac
 * 每个修饰符的作用和修饰普通成员时一样
 * @author WLF
 *
 */
public class SimpleInner {
	//内部类
	public class One{
		public One() {
			System.out.println("create One");
		}
	}
	protected  class Two{
		public Two() {
			System.out.println("create Two");
		}
	}
	class Three{
		public Three() {
			System.out.println("create Three");
		}
	}
	@SuppressWarnings("unused")
	private class Four{
		public Four() {
			System.out.println("create Four");
		}
	}
	public final class Five{
		public Five() {
			System.out.println("create Five");
		}
	}
	
	/**
	 * 在外部内中使用非静态方法
	 * 则可以直接调用
	 * @return
	 */
	public One getOne() {
		return this.new One();
	}
	
	public static void main(String[] args) {
		/**
		 * 通过在调用类中创建外部类实例，
		 * 从而创建该类中的成员内部类实例。
		 */
		SimpleInner inner=new SimpleInner();
		One one=inner.new One();
		inner.new Two();
	}
}
