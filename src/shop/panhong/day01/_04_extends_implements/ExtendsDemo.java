package shop.panhong.day01._04_extends_implements;


/**
 * 	案例:存在50个苹果,现在有请三个童鞋(小A,小B,小C)上台表演吃苹果.
 * 		因为A,B,C三个人可以同时吃苹果,此时得使用多线程技术来实现这个案例.
 *      此处程序不合理,ABC每个线程都执行50次,即ABC每个人都吃一次编号50的苹果
 */
class Person extends Thread {
	private int num = 50; //苹果总数

	public Person(String name) {
		super(name); //调用父类中获取线程名的方法
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if (num > 0) {
				System.out.println(super.getName() + "吃了编号为" 
						+ num-- + " 苹果");
			}
		}
	}
}

public class ExtendsDemo {
	public static void main(String[] args) {
		new Person("A").start();// 每个同学相当于一个线程
		new Person("B").start();
		new Person("C").start();
//		Person p = new Person();
//		new Thread(p, "A").start();// Thread(Runnable target, String name)
//		new Thread(p, "B").start();
//		new Thread(p, "C").start();
	}
}
