package sec01;

public class DmbCellphoneExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DmbCellphone dmbCellphone = new DmbCellphone("자바폰", "검정", 10);
		
		//CellPhone으로부터 상속받은 필드(멤버변수)
		System.out.println("모델: " + dmbCellphone.model);
		System.out.println("색상: " + dmbCellphone.color);
		
		//DmbCellphone으로부터상속받은 메소드를 호출
		dmbCellphone.powerOn();
		dmbCellphone.bell();
		dmbCellphone.sendVoice("여보세요.");
		dmbCellphone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
		dmbCellphone.sendVoice("아~예 반갑습니다");
		dmbCellphone.hangUp();
		
		//DmbCellphone의 메서드 호출
		dmbCellphone.turnOnDmb();
		dmbCellphone.changeChannelDmb(12);
		dmbCellphone.turnOffDmb();
	}
}