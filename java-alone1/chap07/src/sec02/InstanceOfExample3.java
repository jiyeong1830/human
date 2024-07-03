package sec02;

public class InstanceOfExample3 {
	//부모 클래스를 자식 클래스로 강제형변환을 안전하게 리턴하는 메소드
	public static void method1(Parent parent) {		
		if(parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("method1 - Child로 변환성공");
		}else {
			System.out.println("method1 - Child로 변환하지않음");
		}
	}
	
	public static void method2(Parent parent) {	
		Child child= (Child) parent;
		System.out.println("method2 - Child로 변환성공");
	}
	
	//부모 클래스를 자식 클래스로 강제형변환을 불안전하게 리턴하는 메소드
	public static void main(String []args) {
		Parent parentA = new Child();
		method1(parentA);
		method2(parentA);
		
		Parent parentB = new Child();
		method1(parentB);
		method2(parentB);
	}
}