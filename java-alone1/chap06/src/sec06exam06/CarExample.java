package sec06exam06;

public class CarExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car();
		
		//잘못된 속도 변경
		myCar.setspeed(-50);
		
		System.out.println("현재속도: " + myCar.getSpeed());
        
		//올바른 석도 변경
		myCar.setspeed((60));
		
		//멈춤
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		
		System.out.println("현재속도: " + myCar.getSpeed());
	}

}