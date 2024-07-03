package sec05;

public class ClassName {
	//인스턴스 필드
	int field1;
	//인스턴스 메소드
	void method1() {}
		
	//정적 필드
	static int field2;
	//정적 메소드
	static void method2() {}
		
	static void method3() {
		//this.field1 = 10;
		
		field2 = 10;
		method2();
	}
}
