package shop.panhong.day01._01_why;

public class GameDemo {
	public static void main(String[] args) {
		Game();
		Music();

	}

	private static void Game() {
		for (int i = 0; i < 20; i++) {
			System.out.println("打游戏" + i);
		}
	}

	private static void Music() {
		for (int i = 0; i < 20; i++) {
			System.out.println("播放音乐" + i);
		}
	}
}
