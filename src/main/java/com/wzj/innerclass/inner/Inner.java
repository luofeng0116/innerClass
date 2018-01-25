package com.wzj.innerclass.inner;

/**
 * 嵌套内部类
 * @author WLF
 *
 */
public class Inner {
	public class InnerOne{
		public InnerOne() {
			System.out.println("create InnerOne");
		}
	}
	public static void main(String[] args) {
		Inner inner=new Inner();
		InnerOne innerOne=inner.new InnerOne();
	}
	
}

