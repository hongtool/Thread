package shop.panhong.day01._03_thread;

// Thread方法
/**
 * 需求 :一边玩游戏一般播放音乐
 * 步骤: 1自定义一个类 A 继承 Thread
 * 		2 复写Thread的run()方法
 *		3 在run方法里面编写要执行的 线程执行体
 *		4创建自定义类A的对象
 *		5 对象调用start方法
 */
// 播放音乐的线程类
class Music extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 33; i++) {
			System.out.println("播放音乐" + i);
		}
	}
}

public class ExtendsThreadDemo {
	public static void main(String[] args) {
		// 主线程 ; 运行游戏
		for (int i = 0; i < 33; i++) {
			System.out.println("打游戏" + i);
			if (i == 10) {
				// 创建线程对象,并启动新线程
				Music m = new Music();
				m.start(); // 不能调用run().否则还是单线程,并没有开启新的线程
			}
		}
	}
}
