package shop.panhong.day02._01_producer_consumer;

//共享资源对象,姓名-性别
public class ShareResource {

	private String name;
	private String gender;
	
	/**
	 * 生产者向共享资源对象中存储数据
	 * @param name 存储的姓名
	 * @param gender 存储的性别
	 */
	synchronized public void push(String name,String gender){
		this.name = name;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.gender = gender;
		System.out.println("生成了" + this.name + " - " + this.gender);
	}
	
	//消费者从共享资源对象获取数据
	synchronized public void popup(){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.name + " - " + this.gender);
	}
}