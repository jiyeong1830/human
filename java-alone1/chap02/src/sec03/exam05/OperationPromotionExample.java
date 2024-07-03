package sec03.exam05;

public class OperationPromotionExample {

	public static void main(String[] args) {
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		//byte byteValue3 = byteVAlue1 + byteValue2;  error
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(intValue1);
		
		char charValue1 = 'A';
	    char charValue2 = 1;
		//char charValue3 = charValue1 + charValue2;   error
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드=" + intValue2);
		System.out.println("출력문자=" + (char)intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3 / 4;  // 2.5 -> 2
		System.out.println(intValue4);  //2
		
		int intValue5 = 10;
		//int intValue6 = 10 / 4.0;  error
		double doubleValue = intValue5 / 4.0;  //10 / 4.0 -> 10.0 / 4.0 = 2.5
		System.out.println(doubleValue);
		
		int x = 1;
		int y = 2;
		double result = (double) x / y;  
		//x -> double 캐스팅(casting). 그래서 y도 double 타입으로 자동변환됨. 1.0 / 2 -> 1.0 / 2.0 -> 0.5
		System.out.println(result);
	}
}