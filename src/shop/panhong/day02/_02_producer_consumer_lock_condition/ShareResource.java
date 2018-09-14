package shop.panhong.day02._02_producer_consumer_lock_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//创建共享资源对象
public class ShareResource {
	private String name;
	private String gender;
	private boolean isEmpty = true; // 表示共享资源 是否为空的状态
	private final Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();// 返回绑定到此 Lock 实例的新

	// 生产者向资源对象存储数据
	public void push(String name, String gender) {
		lock.lock(); // 获取锁
		try {
			while (!isEmpty) {// 表示当前资源状态不为空,等着消费者来消费
				condition.await();// 使用同步锁对象来调用,表示当前线程释放同步锁,进入等待池,等待被唤醒
			}
			// isEmpty 为true ,开始 生成
			// ---------生产开始-------------
			this.name = name;
			Thread.sleep(10);
			this.gender = gender; // 到此生成结束,赋值isEmpty为false
			isEmpty = false; // 设置资源对象不为空
			// ---------生产结束-------------
			condition.signalAll();// 生成完成.唤醒一个消费者
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	// 消费者从共享资源对象获取数据
	public void popup() {
		lock.lock(); // 获取锁
		try {
			while (isEmpty) {// 表示当前资源为空,等待生产者生成对象
				condition.await();// 使用同步锁对象来调用,表示当前线程释放同步锁,进入等待池,等待被唤醒
			}
			// ---------消费开始-------------
			Thread.sleep(10);
			System.out.println(this.name + "-" + this.gender);// 消费完成
			// ---------消费结束-------------
			isEmpty = true;
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}