package sec1;

public class NumberFormatExceptionExample {
	public static void main(String[] args) {
		String data1 = "100";
		String data2 = args[0];

		//문자열 data1 100을 숫자1000으로 변경 시도
		int value1 = Integer.parseInt(data1);
		//문자열 data2 a100을 숫자로 변경 시도
		int value2 = Integer.parseInt(data2);
		//a를 숫자로 바꿀 수 없어서 NumberFormatException이 발생
	}

}
