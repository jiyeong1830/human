package sec02;

public class Anonymous {
	Person person1 = new Person();
	Person person2 = new Person() {
		void work() {
			
		}
		
		@Override
		void wake() {
			
		}
	};
}
