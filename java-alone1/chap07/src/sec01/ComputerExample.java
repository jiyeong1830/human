package sec01;

public class ComputerExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = 10;
		
		Calculator calculator = new Calculator();
		System.out.println("원면적 : "  + calculator.areaCircle(r));
		System.out.println();
		
		Calculator computer = new Calculator();
		System.out.println("원면적 : "  + calculator.areaCircle(r));
	}
}
