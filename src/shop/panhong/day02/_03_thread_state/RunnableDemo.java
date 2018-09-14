package shop.panhong.day02._03_thread_state;

//线程生命周期的各种状态
class Other extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("other -" + i);
		}
	}
}

public class RunnableDemo {
	public static void main(String[] args) throws Exception {

		// Other other = new Other();// 此时属于新建状态
		// other.start();//调用start之后属于可运行状态

		// System.out.println("begin..");
		// System.in.read();// 表示接受键盘的输入数据
		// System.out.println("end..");

		Other other = new Other();
		for (int i = 0; i < 50; i++) {
			System.out.println("mian " + i);
			if (i == 10) {
				other.start();
			}
		}

		// if (!other.isAlive()) {// 当other线程死亡的时候
		// other.start();// 再次启动线程报错(线程只能启动一次)
		// }

	}
}
