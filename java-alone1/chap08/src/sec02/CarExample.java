package sec02;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.run();//한국타이어가 굴러갑니다 x 4
		
		myCar.frintLeftTire = new KumhoTire();
		myCar.frintRightTire = new KumhoTire();
		
		myCar.run();
	}

}
