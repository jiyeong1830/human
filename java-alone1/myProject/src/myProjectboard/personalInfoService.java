package myProjectboard;

import java.sql.*;
import java.util.*;

public class personalInfoService {
    Scanner scanner = new Scanner(System.in); // 키보드입력 받는 객체
    
    /**
     * 설명: 회원정보 작성
     */
    public int insertBoard() {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 회원 아이디 받기
        System.out.print("아이디(취소: quit): ");
        String id = scanner.nextLine();
        if (id.equals("quit")) {
            System.out.println("작성이 취소되었습니다.");
            return -1;
        }
        
        // 2. 회원 패스워드 받기
        System.out.print("패스워드(취소: quit): ");
        String password = scanner.nextLine();
        if (password.equals("quit")) {
            System.out.println("작성이 취소되었습니다.");
            return -1;
        }
        
        // 3. 회원 이름 받기
        System.out.print("이름(취소: quit): ");
        String name = scanner.nextLine();
        if (name.equals("quit")) {
            System.out.println("작성이 취소되었습니다.");
            return -1;
        }
        
        // 4. 회원 생일 받기
        System.out.print("생년월일(취소: quit): ");
        String date_of_birth = scanner.nextLine();
        if (date_of_birth.equals("quit")) {
            System.out.println("작성이 취소되었습니다.");
            return -1;
        }
        
        // 5. 전화번호 받기
        System.out.print("전화번호(취소: quit): ");
        String phone_number = scanner.nextLine();
        if (phone_number.equals("quit")) {
            System.out.println("작성이 취소되었습니다.");
            return -1;
        }
        
        // 6. 이메일 받기
        System.out.print("이메일(취소: quit): ");
        String email = scanner.nextLine();
        if (email.equals("quit")) {
            System.out.println("작성이 취소되었습니다.");
            return -1;
        }
        
        // 7. DB 접속 준비
        Connection conn = DBManager.getDBConnection();
        
        // 8. insert SQL문 작성
        String insertSql = """
            INSERT INTO personal_info(seq, id, password, name, date_of_birth, phone_number, email) 
            VALUES(seq_personal_info_no.NEXTVAL, ?, ?, ?, ?, ?, ?)
        """;
        
        int resultRows = 0; // insert문을 실행한 뒤에 영향을 받은 행 개수
        PreparedStatement pstmt = null;
        
        try {
            // 9. SQL 실행 준비
            pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, id); 
            pstmt.setString(2, password); 
            pstmt.setString(3, name); 
            pstmt.setString(4, date_of_birth); 
            pstmt.setString(5, phone_number); 
            pstmt.setString(6, email); 
            
            // 10. SQL 실행
            resultRows = pstmt.executeUpdate();
            
            System.out.println("회원정보가 성공적으로 등록되었습니다.");
        } catch(SQLException se) {
            System.out.println("회원정보 삽입 중 에러 발생 -> " + se.getMessage());
        } finally {
            // 11. DB 접속 객체 정리
            DBManager.dbClose(conn, pstmt, null);
        }
        
        return resultRows;
    }

	/**
	 * 설명: 회원 목록조회
	 */
    public void selectAllBoard() {
        // 회원 목록조회 화면구성
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("번호       회원명                              아이디                                    전화번호             ");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        // Oracle DB의 Board테이블에서 위의 3가지 항목(번호, 아이디, 회원명, 전화번호)이 나오도록 출력
        // 1. 회원의 데이터를 받기 위해 Oracle DB접속준비
        Connection conn = DBManager.getDBConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String selectSql = "SELECT seq, name, id, phone_number FROM personal_info ORDER BY seq DESC";
        int countRows = 0; // 행의 번호

        try {
            pstmt = conn.prepareStatement(selectSql);
            rs = pstmt.executeQuery();

            while(rs.next()) { // sql실행한 데이터들의 1행을 가져옴(데이터가 있으면 true, 없으면 false)
                countRows++; // 행의 개수를 1증가

                System.out.println(
                    String.format("%-10s", rs.getString("seq")) +
                    String.format("%-33s", rs.getString("name")) +
                    String.format("%-40s", rs.getString("id")) +
                    String.format("%-10s", rs.getString("phone_number")) 
                );
            }
            if (countRows == 0) { // personal_info 테이블에 데이터가 없을 경우
                System.out.println("상품이 존재하지 않습니다.");
            }
        } catch(SQLException se) {
            System.out.println("상품 목록 조회하는 도중 에러가 발생 -> " + se.getMessage());
        } finally {
            // Oracle DB 접속 관련 객체들 정리
            DBManager.dbClose(conn, pstmt, rs);
        }
    }
	
	/**
	 * 설명: 콘솔에서 사용자의 키보드 입력받은 값을 리턴
	 * @return 회원 번호
	 */
	private int getBoardNo() {
		int boardNo = 0;
		while(true) {
			System.out.println("회원 번호를 입력하세요.> ");
			
			try {
				boardNo = Integer.parseInt(scanner.nextLine());
				break;
			} catch(InputMismatchException | NumberFormatException e) {
				System.out.println("잘못된 값을 입력하셨습니다. 다시 입력을 해주세요.");
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("알 수 없는 오류 -> " + e.getMessage());
			}	
		}
		
		return boardNo;
	}
	
	/**
	 * 설명: 회원 정보 상세조회
	 */
	public void selectOneBoard() {
	    int boardNo = getBoardNo();

	    // 1. 회원의 상세 데이터를 받기 위해 Oracle DB접속준비
	    Connection conn = DBManager.getDBConnection();
	    
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        String countSql = "SELECT COUNT(*) FROM personal_info WHERE seq = ?";
	        // sql실행(countSql)
	        pstmt = conn.prepareStatement(countSql);
	        pstmt.setInt(1, boardNo);
	        rs = pstmt.executeQuery(); // select 실행(count)

	        if (rs.next()) { // sql실행한 데이터들의 1행을 가져옴(데이터가 있으면 true, 없으면 false)
	            int rowCount = rs.getInt(1); // count(*)값 가져오기
	            
	            if (rowCount == 0) { // 상세조회할 게시글이 없는 경우
	                System.out.println("상세조회할 회원 번호가 없습니다.");
	                return;
	            }
	        }
	        // pstmt와 rs를 닫고 새 쿼리를 실행하기 위해 초기화
	        DBManager.dbClose(null, pstmt, rs);

	        // 2. 상세조회할 sql 코드들 작성
	        String detailSelectSql = "SELECT * FROM personal_info WHERE seq = ?";
	        // sql 실행(detailSelectSql)
	        pstmt = conn.prepareStatement(detailSelectSql);
	        pstmt.setInt(1, boardNo);
	        rs = pstmt.executeQuery(); // select 실행(detail)
	        
	        if (rs.next()) { // sql 실행한 데이터들의 1행을 가져옴(데이터가 있으면 true, 없으면 false)
	            // 4. sql 실행해서 가져온 데이터들을 자바변수에 세팅 혹은 출력
	            // 5. 회원 상세조회 출력 화면
	            System.out.println("-------------------------------------------------------------");
	            System.out.println("회원 번호: " + rs.getInt("seq"));
	            System.out.println("아이디: " + rs.getString("id"));
	            System.out.println("패스워드: " + rs.getString("password"));
	            System.out.println("회원명: " + rs.getString("name"));
	            System.out.println("생년월일: " + rs.getInt("date_of_birth"));
	            System.out.println("전화번호: " + rs.getInt("phone_number"));
	            System.out.println("이메일: " + rs.getString("email"));
	            System.out.println("-------------------------------------------------------------");
	        }
	    } catch(SQLException se) {
	        System.out.println("회원정보 상세조회 쿼리 실행 오류: " + se.getMessage());
	    } finally {
	        // Oracle DB 접속 관련 객체들 정리
	        DBManager.dbClose(conn, pstmt, rs);
	    }
	}
	
	/**
	 * 설명: 회원정보 삭제
	 */
	public void deleteOneBoard() {
		System.out.println("삭제할 회원 번호를 입력하세요.> ");
		int boardNo = Integer.parseInt(scanner.nextLine());
		
		// 삭제 더블체크
		System.out.print("정말 " + boardNo + "번 회원정보을 삭제하시겠습니까? (Y/N)");
		String confirmYN = scanner.nextLine();
		if (!confirmYN.equals("Y"))
			return;

		// 1. 회원의 상세 데이터를 받기 위해 Oracle DB접속준비
		Connection conn = DBManager.getDBConnection();
		
		// 입력한 회원 번호의 개수를 가져오기
		String countSql = "SELECT COUNT(*) FROM personal_info WHERE seq = ?";
		
		// 회원 특정번호 삭제 sql
		String deleteOneSql = "DELETE FROM personal_info WHERE seq = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultRow = 0;
		
		try {
			// sql실행
			pstmt = conn.prepareStatement(countSql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery(); // select실행
			if (rs.next()) {
				resultRow = rs.getInt(1); // count(*)값 가져오기
				
				if (resultRow == 0) {
					System.out.println("삭제할 회원 번호가 없습니다.");
					return;
				}
			}
						
			// sql실행
			pstmt = conn.prepareStatement(deleteOneSql);
			pstmt.setInt(1, boardNo);
			resultRow = pstmt.executeUpdate(); // delete실행

			System.out.println("회원 번호 " + boardNo + "를 성공적으로 삭제하였습니다.");
		} catch(SQLException se) {
			System.out.println("회원 삭제 쿼리 실행 오류: " + se.getMessage());
		} finally {
			// Oracle DB 접속 관련 객체들 정리
			DBManager.dbClose(conn, pstmt, rs);
		}
	}
	
	/**
	 * 설명: 회원정보 수정
	 */
	public void updateOneBoard() {
        // 1. 수정할 회원 번호   
        System.out.println("수정할 회원 번호를 입력하세요.> ");
        int boardNo = Integer.parseInt(scanner.nextLine());

        // 입력한 회원 번호의 개수를 가져오기
        String countSql = "SELECT COUNT(*) FROM personal_info WHERE seq = ?";

        // 회원의 상세 데이터를 받기 위해 Oracle DB접속준비
        Connection conn = DBManager.getDBConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int resultRow = 0;

        try {
            // 3. sql실행
            pstmt = conn.prepareStatement(countSql);
            pstmt.setInt(1, boardNo);
            rs = pstmt.executeQuery(); // select실행(count)

            if (rs.next()) {
                resultRow = rs.getInt(1);
                if (resultRow == 0) {
                    System.out.println("없는 회원 번호입니다.");
                    return;
                }
            }
        } catch (SQLException se) {
            System.out.println("회원 번호 개수 쿼리 실행 오류: " + se.getMessage());
            return;
        } finally {
            // 자원 해제
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("자원 해제 중 오류 발생: " + e.getMessage());
            }
        }

        // 2. 수정할 아이디
        System.out.println("수정할 아이디를 입력하세요.> ");
        String updateId = scanner.nextLine();
        // 3. 수정할 패스워드
        System.out.println("수정할 패스워드를 입력하세요.> ");
        String updatePassword = scanner.nextLine();
        // 4. 수정할 회원명
        System.out.println("수정할 회원명을 입력하세요.> ");
        String updateName = scanner.nextLine();
        // 5. 수정할 생년월일
        System.out.println("수정할 생년월일을 입력하세요.> ");
        String updateDate_of_birth = scanner.nextLine();
        // 6. 수정할 전화번호
        System.out.println("수정할 전화번호를 입력하세요.> ");
        String updatePhone_number = scanner.nextLine();
        // 7. 수정할 이메일
        System.out.println("수정할 이메일을 입력하세요.> ");
        String updateEmail = scanner.nextLine();

        // 8. 회원 정보 수정 sql
        String updateOneSql 
            = "UPDATE personal_info SET id = ?, password = ?, name = ?, date_of_birth = ?, phone_number = ?, email = ? WHERE seq = ?";

        try {
            // 9. sql실행
            pstmt = conn.prepareStatement(updateOneSql);
            pstmt.setString(1, updateId);
            pstmt.setString(2, updatePassword);
            pstmt.setString(3, updateName);
            pstmt.setString(4, updateDate_of_birth);
            pstmt.setString(5, updatePhone_number);
            pstmt.setString(6, updateEmail);
            pstmt.setInt(7, boardNo);
            resultRow = pstmt.executeUpdate(); // update실행

            if (resultRow > 0) {
                System.out.println("회원 번호 " + boardNo + "를 성공적으로 수정하였습니다.");
            } else {
                System.out.println("회원 번호 " + boardNo + "를 수정하는데 실패하였습니다.");
            }
        } catch (SQLException se) {
            System.out.println("회원 수정 쿼리 실행 오류: " + se.getMessage());
        } finally {
            // 자원 해제
            DBManager.dbClose(conn, pstmt, rs);
        }
    }
}