package sec04;

public class MemberService {
	boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("12345")) {
			return false;
		} else {
	    	return false;
	    }
	 }
	
	public void logout(String id) {
		System.out.println("로그아웃되었습니다.");
	}
}