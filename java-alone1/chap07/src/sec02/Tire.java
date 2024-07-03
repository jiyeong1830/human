package sec02;

public class Tire {
	//세개의 필드
	public int maxRotation;  //최대회전수(최대수명)
	public int accumulatedRotation;  //누적회전수
	public String location;  //타이어의 위치
	
	//한개의 생성자
	public Tire(String location, int maxRotation) {
		this.location = location =location;
		this.maxRotation = maxRotation;
	}
	
	//한개의 메소드
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "Tire 수명: " + (maxRotation - accumulatedRotation) + "회");
			return true;
			} else {
				System.out.println("*** " + location + " Tire 펑크 ***");
				return false;
			}
	}
}