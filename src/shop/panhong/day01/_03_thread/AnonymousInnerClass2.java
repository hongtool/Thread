package shop.panhong.day01._03_thread;

// Runnable
/***
 * 格式： new 父类构造器([实参列表]) 或 接口()
 *		 { 
         //匿名内部类的类体部分
      	}
    注意：匿名内部类必须继承一个父类或者实现一个接口，但最多继承一个父类或实现一个接口。.

 * 
 */
public class AnonymousInnerClass2 {
	public static void main(String[] args) {
		// 主线程 :运行游戏
		for (int i = 0; i < 33; i++) {
			System.out.println("打游戏" + i);
			if (i == 10) {
				new Thread(new Runnable(){
					@Override
					public void run(){
						for (int j = 0; j < 33; j++) {
							System.out.println("播放音乐"+ j);
						}
					}
				}).start();
				//注意  这里调用的必须是Runnable的对象或者Runnable实现类的对象
			}
		}
	}
}
