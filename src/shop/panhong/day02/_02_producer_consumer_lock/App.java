package shop.panhong.day02._02_producer_consumer_lock;

public class App {
	public static void main(String[] args) {
		ShareResource resource = new ShareResource();
		new Thread(new Producer(resource)).start();
		new Thread(new Consumer(resource)).start();
//		new Thread(new Producer(resource)).start();
//		new Thread(new Consumer(resource)).start();
	}
}
