package sec01;

public class Parent02 {
	public String nation;
	
	public Parent02 () {
		this("대한민국");
		System.out.println("sec07exam05 () call");
	}
	
	public Parent02 (String nation) {
		this.nation = nation;
		System.out.println("sec07exam05(String nation) call");
	}
}
