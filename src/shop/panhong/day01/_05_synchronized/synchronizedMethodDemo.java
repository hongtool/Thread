package shop.panhong.day01._05_synchronized;

/**
 *  同步方法: 把需要同步的操作代码定义 在一个新的方法里面,并且用synchronized修饰符修饰
 *  然后再在run的方法中调用  不可以直接修饰 run方法
 *
 */
class Apple3 implements Runnable {
	private int num = 50;

	public void run() { // run中不能用synchronized修饰 ,否则不会产生多线程
		for (int i = 0; i < 50; i++) {
			eat();
		}
	}

	// 定义在方法上 , 必须保证方法内的所有功能同步完成
	synchronized public void eat() {
		if (num > 0) {
			System.out.println(Thread.currentThread().getName() + "吃了编号为"
					+ num-- + "的苹果");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class synchronizedMethodDemo {
	public static void main(String[] args) {
		Apple3 a = new Apple3();
		new Thread(a, "A").start();
		new Thread(a, "B").start();
		new Thread(a, "C").start();
	}
}