package sec01;

public class SmartPhone extends Object{
	//field
	private String company;
	private String os;
	
	//constructor
	public SmartPhone(String os) {
		super();
		this.company = company;
		this.os = os;
	}
	
	//method
	@Override
	public String toString() {
		System.out.println("SmartPhone이 toString(이 실행됨");
		return company + "," + os;
	}
}