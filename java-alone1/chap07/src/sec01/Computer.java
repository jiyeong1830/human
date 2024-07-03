package sec01;

public class Computer extends Calculator {
	@Override   //부모클래스이 메소드를 재정하겠다고 선언
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
}