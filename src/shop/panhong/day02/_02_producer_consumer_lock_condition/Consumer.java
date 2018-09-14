package shop.panhong.day02._02_producer_consumer_lock_condition;

public class Consumer implements Runnable {
	private ShareResource resource = null;

	// 创建一个构造器,并接收shareresource类型的对象 对其进行初始化
	public Consumer(ShareResource resource) {
		this.resource = resource;
	}

	// 消费者消费
	public void run() {
		for (int i = 0; i < 50; i++) {

			resource.popup();
		}
	}

}