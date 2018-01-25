package com.wzj.innerclass.inner;

/**
 * 匿名内部类
 * 匿名内部类没有名称。所以不能被外部类或其他类实例化。
 * @author WLF
 *
 */
public class NoNameInner {
	//接口式的匿名内部类
	IA a=new IA() {
		public void say() {
			System.out.println("IA say");
		}
	};
	//参数式匿名内部类
	Base b=new Base() {
		void say() {
			this.defaultSay(new IA() {
				public void say() {
					System.out.println("参数IA say");	
				}

			});
		}
	};
	
	
	public static void main(String[] args) {
		NoNameInner inner=new NoNameInner();
		inner.a.say();
		inner.b.say();
	}
	
	
	interface IA{
		void say();
	}
	abstract class Base{
		abstract void say();
		void defaultSay(IA a){
			System.out.println("Base defaultSay"+a.toString());
		}
	}
}
