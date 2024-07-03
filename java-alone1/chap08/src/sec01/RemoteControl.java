package sec01;

public interface RemoteControl {
	//상수(필드)}
	public int MAX_VOLUME = 10;
	//public final static 변수
	public int MIN_VOLUME = 0;
	//public final static 변수;
	
	//추상메소드
	void turnOn();
	void turnOff();
	void setVolume();
}