package myProjectboard;

import java.util.Scanner;

public class shoppingmallBoard {
	
	public static void main(String[] args) {
		System.out.println("쇼핑몰 프로그램 시작");
		
		shoppingmallService shoppingboardService = new shoppingmallService();	// 프로그램 접근 및 제어 객체 생성
		Scanner scanner = new Scanner(System.in);			// 키보드입력 받는 객체
		
		// 0. 쇼핑몰 프로그램 대기를 위해 무한루프 코드 작성
		while(true) {
			// 프로그램 제목
			System.out.println("                    << 쇼핑몰 >>");
			// 쇼핑몰 메뉴
			System.out.println("(1.상품 작성, 2.상품 목록, 3.상세보기, 4.상품 수정, 5.상품 삭제, 6.종료)>> ");

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
				case 1:	// 새 상품 작성 실행
					System.out.println("(상품 작성)");
					
					shoppingboardService.insertBoard();
					break;
				case 2:	// 상품 목록 실행
					System.out.println("(상품 목록)");
					
					shoppingboardService.selectAllBoard();
					break;
				case 3:	// 상세보기 실행
					System.out.println("(상세보기)");
					
					shoppingboardService.selectOneBoard();
					break;
				case 4:	// 상품 수정 실행
					System.out.println("(상품 수정)");
					
					shoppingboardService.updateOneBoard();
					break;
				case 5: // 상품 삭제 실행
					System.out.println("(상품 삭제)");
					
					shoppingboardService.deleteOneBoard();
					break;
			}
			if(menuNumber == 6) {	// 6번일 때는 무한루프를 빠져나가게 하여 프로그램을 종료
				System.out.println("(종료)");
				break;
			}
		}
		
		// 프로그램 종료 표시
		System.out.println("쇼핑몰 프로그램 종료");
	}
}

