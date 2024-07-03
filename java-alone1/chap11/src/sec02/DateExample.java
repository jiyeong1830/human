package sec02;

import java .text.*;
import java.util.*;

public class DateExample {
	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf =
			new SimpleDateFormat("yyyy년 mm월 dd일 hh시 mm분 ss초");  //yyyy-MM-dd HH:mm:ss
			String strNow2 = sdf.format(now);
			System.out.println(strNow2);
	}

}
