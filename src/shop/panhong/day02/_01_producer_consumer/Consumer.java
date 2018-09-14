package shop.panhong.day02._01_producer_consumer;

//消费者
public class Consumer implements Runnable{
	//共享资源对象
	private ShareResource resource = null ;
	
	public Consumer(ShareResource resource){
		this.resource  = resource ;
	}
	
	//消费者消费对象
	@Override
	public void  run() {
		for (int i = 0; i < 50; i++) {
			resource.popup();
		}
	}
}
