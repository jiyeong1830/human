package sec02;

public class ArrayCopyExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 첫번째 방법 -> for문 활용
		int[] oldIntArray = {1,2,3};
		int[] newIntArray = new int[5];   //{0,0,0,0,0}
		
		// 원소 복사
		for(int i=0; i<oldIntArray.length; i++) {
			newIntArray[i] =oldIntArray[i];
		}
		//확인 풀력
		for(int i=0; i<newIntArray.length; i++) {
			System.out.println(newIntArray[i] + ", ");
		}
		//두번째 방법 -> System.arraycopy()를 이용
		//(Object scr, int scrPos, Object desc, int destPost, int length) 메소드 활용
		String[] oldStrArray = {"Java", "array", "copy"};
		String[] newStrArray = new String[5];
		
		//원소 복사
		System.arraycopy(oldStrArray,0,newStrArray,0, oldStrArray.length);
		
		//확인 출력
		for(int i=0; i<newIntArray.length; i++) {
			System.out.println(newIntArray[i] + ", ");
	
		}
	}
}
