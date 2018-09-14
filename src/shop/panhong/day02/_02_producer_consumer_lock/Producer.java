package shop.panhong.day02._02_producer_consumer_lock;

public class Producer implements Runnable {
private ShareResource resource  = null;
//创建一个带shareresource类型参数的构造器. 下次new 的时候进行初始化
 public Producer(ShareResource resource){
	 this.resource= resource;
 }
	public void run() {
for (int i = 0; i < 50; i++) {
	if( i % 2 == 0){
		resource.push("春哥", "男");
	}else{
		resource.push("凤姐", "女");
	}
}
	}

}