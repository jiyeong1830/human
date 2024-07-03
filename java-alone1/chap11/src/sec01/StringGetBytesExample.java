package sec01;

public class StringGetBytesExample {
	public static void main(String[] args) {
		String str = "안녕하세요";    
		
		byte[] bytes1  = str.getBytes();      //인코딩(encoding)
		System.out.println("bytes1.length: " + bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1->String: " + str1);
		
		try{
			//euc-kr(대소문자 구분 안함) -> 한국어 인코딩 타입 이름
			//utf-8(대소문자 구분 안함) -> 다국어 인코딩 타입 이름
			
			byte[] bytes2  = str.getBytes();   //디코딩(decoding)
			System.out.println("bytes2.length: " + bytes2.length);
			String str2 = new String(bytes2);
			System.out.println("bytes2->String: " + str2);
			
			byte[] bytes3  = str.getBytes(); //utf-8로 인코딩 utf-8은 3byte
			System.out.println("bytes3.length: " + bytes3.length); //3byte * 5 -> 15개
			String str3 = new String(bytes3);               //uft-8로 디코딩(decoding)
			System.out.println("bytes3->String: " + str3);  //안녕하세요
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
