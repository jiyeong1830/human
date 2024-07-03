package sec01;

import java.util.List;
import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
		//리스트 원소 추가
		List<String> list = new ArrayList<String>();
		//String으로 여러 개의 객체를 Array처럼 사용하도록 ArrayList객체를 생성
		list.add("Java");
		//"Java"값을 가진 String 객체를 0번째 인덱스에 추가 및 저장
		list.add("JDBC");
		//"JDBC"값을 가진 String 객체를 1번째 인덱스에 추가 및 저장
		list.add("Servlet/JSP");
		//"Servlet/JSP"값을 가진 String 객체를 2번쨰 객체에 저장
		list.add("Database");
		//2번쩨 인덱스에 "Database"값을 가진 String 객체를 저장.3번째 인덱스에 "Servlet/JSP"값이 저장
		list.add("iBATIS");
		//4번째 인덱스에 "iBatis" 값을 가진 String 객체를 저장
		
		int size = list.size();  //5 : 저장된 총 객체의 수
		System.out.println("총 객체 수: " + size);
		System.out.println();    //한 줄 띄우기
		
		//리스트 원소 검색
		String skill = list.get(2);  //2번 인덱스에 저장된 객체 얻기
		System.out.println("2: " + skill); //2: Database
		System.out.println(); //한 줄 띄우기
		
		//리스트 개수만큼 순회하여 값을 찍음
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ";" + str);
		}
		System.out.println(); // 한 줄 띄우기
		
		//리스트 원소 삭제
		list.remove(2); //인덱스 2번의 값을 삭제 -> Database 삭제
		//list는 다음과 같은 상태 -> 0: Java, 1: JDBC, 2: Servlet/JSP, 3: iBATIS
		list.remove(2); //인덱스 2번의 값을 삭제 -> Servlet/JSP 삭제
		//list는 다음과 같은 상태 -> 0: Java, 1: JDBC, 2: iBATIS
		list.remove("iBATIS"); //값이 "iBATIS"인 것을 삭제
		//list는 다음과 같은 상태 -> 0: Java, 1: JDBC
		
		//리스트 개수만큼 순회하여 값을 찍음
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		
		System.out.println(); // 한 줄 띄우기
		
		//리스트 원소 수정
		list.set(0, "Python2"); 
		
		//리스트 개수만큼 순회하여 값을 찍음
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		
		list.clear(); //0: Java, 1: JDBC 전부 삭제
	}
}