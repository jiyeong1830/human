package sec02;

public class SnowTireExample {
	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire02 tire = snowTire;
		
		snowTire.run();
		tire.run();
	}

}
