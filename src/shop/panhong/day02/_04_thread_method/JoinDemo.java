package shop.panhong.day02._04_thread_method;

//联合线程
class Join extends Thread {
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("Join" + i);
		}
	}
}

public class JoinDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("begin....");
		Join j = new Join();
		for (int i = 0; i < 33; i++) {
			System.out.println("main " + i);
			if (i ==10 ) {
				j.start();//启动join线程
			}
			if (i ==20 ) {
				j.join(); //强制运行该线程,直到结束后才运行另一个线程
			}
		}
		System.out.println("end...");
	}

}
