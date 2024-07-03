package sec02;

public class Car {
	Tire frintLeftTire = new HankookTire();
	Tire frintRightTire = new HankookTire();
	Tire backLeftTire = new HankookTire();
	Tire backRightTire = new HankookTire();
	
	void run() {
		frintLeftTire.roll();
		frintRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
	}
}