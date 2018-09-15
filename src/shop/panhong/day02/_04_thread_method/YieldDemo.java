package shop.panhong.day02._04_thread_method;

//线程礼让
/* sleep方法会给其他线程运行机会,但是不考虑其他线程的优先级,
 * yield方法只会给相同优先级或者更高优先级的线程运行的机会.
 * 调用sleep方法后,线程进入计时等待状态,调用yield方法后,线程进入就绪状态.
 */
class YieldThread extends Thread {
	public YieldThread(String name) {
		super(name);// 调用父类的构造器
	}

	public void run() {
		for (int i = 0; i < 150; i++) {
			System.out.println(super.getName() + "-" + i);
			if (i == 20) {
				Thread.yield();// 当i=20的时候,做出礼让 (效果不明显)
			}
		}
	}
}

public class YieldDemo {
	public static void main(String[] args) {
		
		YieldThread max = new YieldThread("高优先级");
		max.setPriority(Thread.MAX_PRIORITY);
		YieldThread min = new YieldThread("低优先级");
		min.setPriority(Thread.MIN_PRIORITY);
		min.start();
		max.start();

	}
}
