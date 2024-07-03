package sec01;

public class Television {
	//필드
	private int volume;
	
	public void turnOn() {
	//RemoteControl에 있는 turnOn매소드	
		System.out.println("TV를 켭니다.");
	}
	public void turnOff() {
	//RemoteControl에 있는 turnOff매소드
		System.out.println("TV를 끕니다.");
	}
	public void setVolume(int volume) {
	//RemoteControl에 있는 etVolume 매소드	
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨: " + this.volume);
	}
}