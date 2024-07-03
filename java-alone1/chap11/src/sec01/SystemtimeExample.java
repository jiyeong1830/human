package sec01;

public class SystemtimeExample {
	public static void main(String[] args) {
		long time1 = System.nanoTime() ;             //10의 -9승
		//long time3 = System.currentTimeMillis() ;    //10의-6승
		 
		int sum = 0;
		for(int i=1; i<=1000000; i++) {
			sum +=i;
		}
		
		long time2 = System.nanoTime();
		
		//System.out.println("1~1000000까지의 홥: " + sum);
		System.out.println("1~1000000까지의 합: " + sum);
		System.out.println("계산에: " + (time2 - time1) + "나노초가 소요되었습니다.");
		System.out.println("계산에: " + ((time2 - time1) / (double)10000) + "초가 소요되었습니다.");
	}

}
