package shop.panhong.day01._03_thread;

/**
 * 	格式： new 父类构造器([实参列表]) 或 接口()
     	{ 
         //匿名内部类的类体部分
      	}
		注意：匿名内部类必须继承一个父类或者实现一个接口，但最多只能一个父类或实现一个接口。.
 *
 */
//    Thread
public class AnonymousInnerClass {
	public static void main(String[] args) {
		for (int i = 0; i < 33; i++) {
			System.out.println("打游戏" + i);
			if (i == 10) {
				//创建匿名线程对象
				new Thread() {
					@Override
					public void run() {
						for (int j = 0; j < 33; j++) {
							System.out.println("播放音乐" + j);
						}
					}
				}.start();
			}
		}
	}
}
