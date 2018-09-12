package shop.panhong.day01._05_synchronized;

//单例 - 懒汉模式 - 双重检查加锁
class ArrayUtil3 {
	private static volatile ArrayUtil3 instance =  null;
	public static ArrayUtil3 getInstance(){
		if(instance == null){
			synchronized (ArrayUtil3.class) {
				if(instance == null){
					instance = new ArrayUtil3();
				}
			}
		}
		return instance;
	}
	
	public void work(){
		System.out.println("工作");	
	}
		
}
public class ArrayUtilDemo3 {
	public static void main(String[] args){
		ArrayUtil3.getInstance().work();
	}
}
