package sec02;

import java.util.Scanner;

public class exam07 {
	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고| 4.종료");
			System.out.println("---------------------------------");
			System.out.println("선택> ");
		
			int menunum = Integer.parseInt(scanner.nextLine());
			
			switch (menunum) {
				
			case 1:
				System.out.println("예금액> ");
				balance += Integer.parseInt(scanner.nextLine());
				break;
				
			case 2:
				System.out.println("출금액> ");
				balance -= Integer.parseInt(scanner.nextLine());
				break;
				
			case 3:
				System.out.println("잔고> ");
				System.out.println(balance);;
				break;
				
			case 4:
				run = false;
				break;	
			}
			
			System.out.println(); // 한 칸씩 띄우기
			
		}

		System.out.println("프로그램 종료");
	}
}