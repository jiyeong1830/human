package sec01;

public class DmbCellphone extends Cellphone{
	//필드
	int channel;
	 //생성자
	DmbCellphone(String model, String color, int channel) {
		//this.model은 Cellphone에 있는 모델
		//뒤의 model은 매개변수 model
		//super(); 해당코드가 없어도 자동으로 만들어짐
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	//메소드
	void turnOnDmb() {
		System.out.println("채널 " + channel + "번 DMB 방송수신을 시작합니다.");
	}
	
	void changeChannelDmb(int channel){
		this.channel = channel;
		System.out.println("채널 " + channel + "번으로 바꿉니다.");
	}
	void turnOffDmb() {
		System.out.println("DMB 방송수신을 시작합니다.");
	}
}