package shop.panhong.day01._03_thread;

//用Runnable接口实现
/** 需求 :边打游戏边放音乐
* 步骤  	1.自定义一个类A实现Runnable接口(A不是线程类)
* 		2.复写run()方法
* 		3.在run()方法里编写要执行的线程体
*		4.在main()创建线程对象,并且启动线程
*			把自定义的类A对象作为Thread类的构造器参数 ,并调用Thread的start方法
*创建线程类对象:               Thread  t = new Thread(new  A());    
   调用线程对象的start方法:       t.start();

*/
//播放音乐的类
class MusicIR implements Runnable {
	@Override
	public void run(){
		for (int i = 0; i < 33; i++) {
			System.out.println("播放音乐" + i);
		}
	}
	
}
public class ImplementsRunnableDemo {
	public static void main(String[] args) {
		//主线程 : 运行游戏
		for (int i = 0; i < 33; i++) {
			System.out.println("打游戏" + i);
			if (i == 10) {
				MusicIR m = new MusicIR();
				Thread t = new Thread(m);
				t.start();
			}
		}
	}
}