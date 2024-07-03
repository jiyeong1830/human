package sec02;

public class Bus implements Vehicle{

	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
	public void cheakFare() {
		System.out.println("승차요금을 냅니다.");
	}
}