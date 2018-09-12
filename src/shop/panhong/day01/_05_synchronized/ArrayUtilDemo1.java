package shop.panhong.day01._05_synchronized;

//单例模式- 饿汉式
class ArrayUtil {
	private static final ArrayUtil instance = new ArrayUtil();

	private ArrayUtil() {
	}

	public static ArrayUtil getInstance() {
		return instance;
	}

	public void work() {
		System.out.println("工作");
	}

}

public class ArrayUtilDemo1 {
	public static void main(String[] args) {
		ArrayUtil.getInstance().work();
	}

}
