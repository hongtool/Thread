package shop.panhong.day02._01_producer_consumer;


public class App {
	public static void main(String[] args) {
		//创建生产者和消费者的共同对象
		ShareResource resource = new ShareResource();
		//启动生产者线程
		//创建同一个资源对象  是在调用它的时候将他传过来 ,确保是同一个 资源对象
		new Thread(new Producer(resource)).start();
		//启动消费者线程
		new Thread(new Consumer(resource)).start();
	}
}
