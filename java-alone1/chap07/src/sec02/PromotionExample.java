package sec02;

class A {}

class B extends A {}
class C extends A {}

class D extends B {}
class E extends C {}

//자동타입변화(promotion) -> 자식클래스의 객체는 부모객체로 형 변환 시 자동형변환이 됨 
public class PromotionExample {
	public static void main(String[] args) {
		B b= new B();
		C c= new C();
		D d= new D();
		E e= new E();
		
		A a1 =b;
		A a2 =c;
		A a3 =d;
		A a4 =e;
		
		B b1 = d;
		C c1 = e;
		
		//B b3 = e; e는 B를 상속받지 않았기 때문에 자동형변환이 이루어질 수 없음
		//C c3 = d; d는 C를 상속받지 않았기 때문에 자동형변환이 이루어질 수 없음
		
	}
}
