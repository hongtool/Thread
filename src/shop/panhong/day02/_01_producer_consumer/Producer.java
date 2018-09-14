package shop.panhong.day02._01_producer_consumer;

//生产者
public class Producer implements Runnable {
	// 共享资源对象
	private ShareResource resource = null;
	/*//创建同一个资源对象,对共享资源对象进行初始化操作
	 * 这里不可以new ,因为消费者里面再new 就有两个对象   要确保是同一个资源对象
	 * 
	 * resource对象的初始化 :在下面中使用了resource,必须进行初始化 ,不然会报空指针错误,直接赋值不行
	 * 通过构造器实现      构造器的初始化 : 接收一个shareresource类型的对象,在下次其他类中
	 *  new priducer对象时进行初始化
	*/
	public Producer(ShareResource resource) {
		this.resource = resource;
	}

	//生产者生产对象
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {// 生产50个对象
			if (i % 2 == 0) {
				resource.push("凤姐", "女");
			} else {
				resource.push("春哥", "男");
			}
		}
	}
}
