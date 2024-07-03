package sec01;

public class StringRepleceExample {
	public static void main(String[] args) {
		//replace 메소드 사용
		String oldStr = "자바는 객체 지향 언어입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA");
		
		System.out.println(oldStr);
		System.out.println(newStr);
		
		//문자열 잘라내기로 substring 메소드 사용
		String ssn = "880815-1234567";
		
		String firstNum = ssn.substring(0, 6);
		//안쪽은 시작 인덱스 번호, 오른쪽은 가져올 만큼 문자열의 인덱스 번호
		System.out.println(firstNum); //880815
		
		String secondNum = ssn.substring(0, 6);
		//시작 인덱스 번호부터 끝의 인덱스 번호까지의 문자열 가져오기
		System.out.println(secondNum); //880815
	}

}
