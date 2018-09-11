package shop.panhong.day01._02_process;

/**
* 需求 : 在java中开启一个记事本一个进程
* 
* 方式1 :Runtime类的exec方法
* 方式2 :ProcessBuilder的start方法
*
*/
public class ProcessDemo {
	public static void main(String[] args) throws Exception {
		// 方式1 Runtime类的exec方法
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("notepad");
		// 方式2 ProcessBuilder的start方法
		ProcessBuilder bp = new ProcessBuilder("notepad");
		bp.start();
	}
}
