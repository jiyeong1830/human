package sec02;

public class ForPrintFrom1To10Example {
	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		int i = 1;
		for(; i <= 100; i++) {
			System.out.println(i);
		}
		
		for (int j = 0, k = 100; j <= 50 && k >= 50; j++, k--) {
			
		}
		
		for(;;) {  //무한루프 == while(true)
			break;
		}
		
		for(int j = 0; ; j++) { 
			break;
			
		}
	}
}