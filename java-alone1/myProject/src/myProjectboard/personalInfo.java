package myProjectboard;

import java.util.Scanner;

public class personalInfo {
	public static void main(String[] args) {
		System.out.println("회원 가입 시작");
		
		personalInfoService personalInfoService = new personalInfoService();	// 프로그램 접근 및 제어 객체 생성
		Scanner scanner = new Scanner(System.in);			// 키보드입력 받는 객체
		
		// 0. 회원가입 프로그램 대기를 위해 무한루프 코드 작성
		while(true) {
			// 프로그램 제목
			System.out.println("                    << 회원가입 >>");
			// 회원가입 메뉴
			System.out.println("(1.회원정보 작성, 2.회원 목록, 3.회원정보 보기, 4.회원정보 수정, 5.회원정보 삭제, 6.종료)>> ");

			// 1. 메뉴 선택번호를 입력받기
			int menuNumber = 0;
			try {
				menuNumber = Integer.parseInt(scanner.nextLine());	
			} catch(Exception e) {
				System.out.println("잘못된 값을 입력하셨습니다. 다시 입력을 해주세요.");
				continue;
			}
			System.out.print("선택된 번호 -> " + menuNumber);
			
			if (menuNumber < 1 || menuNumber > 6) {
				System.out.println("\n메뉴 번호는 1~6번 사이의 숫자만 가능");
				continue;
			}
			
			switch(menuNumber) {
				case 1:	// 회원정보 작성 실행
					System.out.println("(회원정보 작성)");
					
					personalInfoService.insertBoard();
					break;
				case 2:	// 회원 목록 실행
					System.out.println("(회원 목록)");
					
					personalInfoService.selectAllBoard();
					break;
				case 3:	// 상세보기 실행
					System.out.println("(회원정보 상세보기)");
					
					personalInfoService.selectOneBoard();
					break;
				case 4:	// 회원정보 수정 실행
					System.out.println("(회원정보 수정)");
					
					personalInfoService.updateOneBoard();
					break;
				case 5: // 회원정보 삭제 실행
					System.out.println("(회원정보 삭제)");
					
					personalInfoService.deleteOneBoard();
					break;
			}
			if(menuNumber == 6) {	// 6번일 때는 무한루프를 빠져나가게 하여 프로그램을 종료
				System.out.println("(종료)");
				break;
			}
		}
		
		// 프로그램 종료 표시
		System.out.println("회원가입 프로그램 종료");
	}
}