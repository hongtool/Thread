package shop.panhong.day01._04_extends_implements;

/**
 * 	案例:存在50个苹果,现在有请三个童鞋(小A,小B,小C)上台表演吃苹果.
 * 		因为A,B,C三个人可以同时吃苹果,此时得使用多线程技术来实现这个案例.
 */
class Apple implements Runnable {
	private int num = 50;

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if (num > 0) {
				System.out.println(Thread.currentThread().getName() + "吃了编号为"
						+ num-- + "的苹果");//currentThread 返回对当前正在执行的线程对象的引用。

			}
		}
	}
}

public class ImplementsDemo {
	public static void main(String[] args) {
		Apple a = new Apple();// 创建一个自定义类的对象作为thread构造器的参数

		new Thread(a, "A").start();// Thread(Runnable target, String name)
		new Thread(a, "B").start();
		new Thread(a, "C").start();

	}
}
