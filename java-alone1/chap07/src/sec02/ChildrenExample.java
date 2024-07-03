package sec02;

public class ChildrenExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Parent parent = new Child(); //자동형 변환
		 parent.field1 ="data1";
		 parent.method1();
		 parent.method2();
		 
		 //parent.field2 ="data2"; error
		 //parent.method3();       error
		 
		 //강제형변환(casting)
		 Child child = (Child) parent;
		 //강제형변환(casting) 
		 child.field2 ="data2";
		 child.method3();
		 
		 //Parent parent2 = new Parent();
		 //Child child2 = (Child) parent2;
		 //child.field2 ="data2";
		 //child.method3();  runtime error
	}

}
