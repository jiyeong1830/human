package sec01;
import sec01.A;

public class D extends A{
	public D() {
		super();
		this.field = "value";
		this.method();
	}

}
//protect는 상속받은 곳에서는 모든 사용가능