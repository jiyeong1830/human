package sec01;

public class Child02 extends Parent02 {
	private String name;
	
	public Child02() {
		this("찹쌀이");
		System.out.println("sec07exam05() call");
	}
	
	public Child02(String name) {
		this.name = name;
		System.out.println("sec07exam05() call");
	}
}
