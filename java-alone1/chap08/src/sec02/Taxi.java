package sec02;

public class Taxi implements Vehicle{

	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}
	public void cheakFare() {
		System.out.println("승차요금을 냅니다.");
	}
}