package myProjectboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
	/**
	 * 설명: 오라클 접속 메소드
	 * @return Connection 객체 -> 오라클 접속 객체
	 */
	public static Connection getDBConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");            // 오라클 접속을 위한 Driver 사전작업
		
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 오라클 위치값 저장
			String username = "boarduser1";   // 오라클 접속 계정 id
			String password = "1234";         // 오라클 접속 계정 pw
			
			// 실제 오라클 접속하여 접속을 다루는 객체를 받아서 Connection 클래스 객체에 대입
			conn = DriverManager.getConnection(url, username, password);
			
	    } catch(Exception e) {
	    	e.printStackTrace();      // 에러 추적 표시
	    	
	    	System.out.println("DB연결 오류");
	    }
		
		return conn;
	}
	
	public static void dbClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		//DB 입출력 자원 정리
		try {
			if (rs != null) {   //데이터 가져온 것을 close
				rs.close();
			}
			if (conn != null) { //데이터 가져온 실행을 close
				pstmt.close();
			}
		} catch(SQLException se) {
			se.printStackTrace();
		
			System.out.println("db-sql 생성오류");
		}
	}
}
