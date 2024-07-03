package sec03;

public class Car01 {
	//생성자
	public Car01() { //기본 생성자 선언 
	//만약 기본생성자가 만드로 지지않더라도 내부적으로 기본 생성자가 없다면 자동으로 만들어줌
	//단 다른 생성자가 생성되어있다면 기본 생성자는 자동으로 생성되지 않음
		System.out.println("기본 생성자 출력");
	}
	
	public Car01(String midel, String color, int maxSpeed) {
		System.out.println("인수가 3개인 생성자 출력");
	}
	
	public Car01(String color, int cc) {
		System.out.println("인수가 2개인 생성자 출력");
	}
}