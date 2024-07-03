package sec05;

public class Person {
	final String nation = "Korea";
	final String ssn;
	String name;
	
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
   //final로 선언된 값은 무조곤  클래스 초기화 할때 final로 선언된 변수를 초기화 헤야한다.
	}
}