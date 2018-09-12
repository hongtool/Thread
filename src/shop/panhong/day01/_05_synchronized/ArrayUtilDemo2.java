package shop.panhong.day01._05_synchronized;

//单例 -懒汉模式
class ArrayUtil2{
	private static ArrayUtil2 instance =  null;
	//同步方法:此时同步对象是ArrayUtil2.class
	synchronized public static ArrayUtil2 getInstance(){
		if(instance == null){
			instance = new ArrayUtil2();
		}
		return instance;
	}
	
	public void work(){
		System.out.println("工作");	
	}
		
}
public class ArrayUtilDemo2 {
	public static void main(String[] args){
		ArrayUtil2.getInstance().work();
	}
}
