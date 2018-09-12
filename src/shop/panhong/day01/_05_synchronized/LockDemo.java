package shop.panhong.day01._05_synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// 可重入锁 :ReentrantLock
/*
 * ReentrantLock lock = new ReentrantLock();
 * lock.lock();//加锁
 * try{
 * 		//需要同步的代码
 * } finally {
 * 		lock.unlock();//解锁
 * }
 * */
class Apple5 implements Runnable {
	
	private int num = 50;
	private final Lock lock = new ReentrantLock();
	public void run() {
		for (int i = 0; i < 50; i++) {
			eat();
		}
	}
	private void eat() {
		lock.lock();
		try {
			if(num > 0) {
				System.out.println(Thread.currentThread().getName() + "吃了编号为" + num-- + "的苹果");
				Thread.sleep(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

class LockDemo {
	public static void main(String[] args) {
		Apple5 a = new Apple5();
		new Thread(a,"A").start();
		new Thread(a,"B").start();
		new Thread(a,"C").start();
	}
}
