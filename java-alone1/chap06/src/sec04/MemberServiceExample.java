package sec04;

public class MemberServiceExample {
	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		if(result) {
			System.out.println("로그인되었습니다.");
			memberService.logout("hong");
		}else {
			System.out.println("id 또는 password가 없습니다.");
		}
	}
}
