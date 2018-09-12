package shop.panhong.day01._04_extends_implements;

// Thread.sleep()线程休眠. 模拟网络延迟

class Apple1 implements Runnable {
	private int num = 50;

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if (num > 0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "吃了苹果编号"
						+ num-- + "的苹果");
			} //此处输出的结果 有很多编号重复了 ,而且有负的编号
		}
	}
}

public class SleepDemo {
	public static void main(String[] args) {
		Apple1 a = new Apple1();
		new Thread(a, "A").start();
		new Thread(a, "B").start();
		new Thread(a, "C").start();
	}
}
