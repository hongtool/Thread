package shop.panhong.day02._02_producer_consumer_lock;

//创建共享资源对象
public class ShareResource {
	private String name;
	private String gender;
	private boolean isEmpty = true; // 表示共享资源 是否为空的状态

	// 生产者向资源对象存储数据
	synchronized public void push(String name, String gender) {
		try {
			while (!isEmpty) {// 表示当前资源状态不为空,等着消费者来消费
				this.wait();// 使用同步锁对象来调用,表示当前线程释放同步锁,进入等待池,等待被唤醒
			}
			// isEmpty 为true ,开始 生成
			this.name = name;
			Thread.sleep(10);
			this.gender = gender; // 到此生成结束,赋值isEmpty为false
			isEmpty = false; // 设置资源对象不为空
			this.notifyAll();// 生成完成.唤醒一个消费者
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 消费者从共享资源对象获取数据
	synchronized public void popup() {
		try {
			while (isEmpty) {// 表示当前资源为空,等待生产者生成对象
				this.wait();// 使用同步锁对象来调用,表示当前线程释放同步锁,进入等待池,等待被唤醒
			}
			Thread.sleep(10);
			System.out.println(this.name + "-" + this.gender);//消费完成
			isEmpty = true;
			this.notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
