package sec01;

public class Child extends Parent {
	void method3() {
		System.out.println("Child의 method3");
	}
	
	@Override
	void method2() {
		System.out.println("Child의 method2");
	}
}
