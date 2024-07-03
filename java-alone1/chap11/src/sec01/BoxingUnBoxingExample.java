package sec01;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
		//박싱
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer(100);
		Integer obj3 = new Integer(100);
		
		//언박싱
		int value1 = obj1 .intValue();
		int value2 = obj2 .intValue();
		int value3 = obj3 .intValue();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
	}

}
