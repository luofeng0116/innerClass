package com.wzj.innerclass.inner;



/**
 * 我们把定义在方法内部的内部类称之为局部内部类。
 * 局部内部类只能使用abstract，final修饰符进行修饰
 * @author WLF
 *
 */
public class PartInner {
	public void dd() {
		System.out.println("dd");
	}
	public void say() {
		final int i=1;
		//局部内部类
		class One{
			public One() {
				System.out.println("Part One");
			}
			public void say() {
				System.out.println("只能调用final 修饰的局部变量i="+i);
				System.out.print("调用外部类的dd()方法:");
				dd();
			}
		}
		new One().say();
	}
	
	
	public static void main(String[] args) {
		new PartInner().say();

	}
}
