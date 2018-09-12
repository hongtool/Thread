package shop.panhong.day01._05_synchronized;

//同步代码块
class Apple1 implements Runnable {
	private int num = 50;

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (this) {
				if (num > 0) {
					System.out.println(Thread.currentThread().getName()
							+ "吃了编号为" + num-- + "的苹果");
				}
			}
		}
	}
}

public class SynchronizedBlockDemo {
	public static void main(String[] args) {
		Apple1 a = new Apple1();
		new Thread(a, "A").start();
		new Thread(a, "B").start();
		new Thread(a, "C").start();
	}
}
