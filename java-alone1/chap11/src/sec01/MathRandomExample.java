package sec01;

public class MathRandomExample {
	public static void main(String[] args) {
		// 0.0 <= Math.random()  < 1.0
		// 0.0 * 6 <= Math.random() * 6 < 1.0 * 6 
		// 0.0 <= Math.random() * 6  < 6.0
		int num = (int) (Math.random()*6) + 1;
		System.out.println("주사위 눈: " + num);
	}
}