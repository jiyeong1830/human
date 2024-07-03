package myProjectboard;

import java.sql.*;
import java.util.*;

public class shoppingmallService {
    Scanner scanner = new Scanner(System.in); // 키보드입력 받는 객체
    
    /**
     * 설명: 상품정보 작성
     */
    public int insertBoard() {
        // 1. 상품 이름 받기
        System.out.print("상품명(취소: quit): ");
        String title = scanner.nextLine(); // 키보드로 '글제목'받기
        if (title.equals("quit")) {
            System.out.println("작성이 취소되었습니다.");
            return -1;
        }
        
        // 2. 상품 설명 받기
        System.out.print("상품 설명(취소: quit): ");
        String content = scanner.nextLine(); // 키보드로 '글내용'받기
        if (content.equals("quit")) {
            System.out.println("작성이 취소되었습니다.");
            return -1;
        }
        
        // 3. 상품 색상 받기
        System.out.print("상품 색상(취소: quit): ");
        String color = scanner.nextLine(); // 키보드로 '색상' 받기
        if (color.equals("quit")) {
            System.out.println("작성이 취소되었습니다.");
            return -1;
        }
        
        // 4. 상품 가격 받기
        System.out.print("상품 가격(취소: quit): ");
        String price = scanner.nextLine(); // 키보드로 '가격' 받기
        if (price.equals("quit")) {
            System.out.println("작성이 취소되었습니다.");
            return -1;
        }
        
        // 5. 위의 입력된 게시글의 제목과 내용을 받아서 Oracle DB에 저장할 수 있도록 DB접속준비
        Connection conn = DBManager.getDBConnection();
        
        // 6. Oracle DB에 데이터를 삽입하기 위해 insert sql문을 작성
        String insertSql = """
            INSERT INTO shoppingmallboard(seq, title, content, color, price) 
            VALUES(seq_shoppingmallboard_no.NEXTVAL, ?, ?, ?, ?)
        """;
        
        int resultRows = 0; // insert문을 실행한 뒤에 테이블 영향을 받은 행 개수
        PreparedStatement pstmt = null;
        
        try {
            // 7. Oracle DB에 데이터를 삽입 코드를 실행할 준비
            pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, title); // 위 insertSql에 첫번째?에 키보드로 입력받은 제목을 세팅
            pstmt.setString(2, content); // 위 insertSql에 두번째?에 키보드로 입력받은 내용을 세팅
            pstmt.setString(3, color); // 위 insertSql에 세번째?에 키보드로 입력받은 색상을 세팅
            pstmt.setString(4, price); // 위 insertSql에 네번째?에 키보드로 입력받은 가격을 세팅
            
            // 8. 실제로 sql코드를 실행
            resultRows = pstmt.executeUpdate(); // executeUpdate로 insert, update, delete sql코드를 실행
            
            System.out.println("상품 성공적으로 등록됨~");
        } catch(SQLException se) {
            System.out.println("상품 정보 삽입하는 도중 에러가 발생 -> " + se.getMessage());
        } finally {
            // 9. Oracle DB 접속 관련 객체들 정리
            DBManager.dbClose(conn, pstmt, null);
        }
        
        return resultRows;
    }

	/**
	 * 설명: 쇼핑몰 목록조회
	 */
    public void selectAllBoard() {
        // 상품 목록조회 화면구성
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("번호       상품명                               상품 설명                                  색상              가격              ");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        // Oracle DB의 Board테이블에서 위의 5가지 항목(번호, 상품명, 상품 설명, 색상, 가격)이 나오도록 출력
        // 1. 상품의 데이터를 받기 위해 Oracle DB접속준비
        Connection conn = DBManager.getDBConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String selectSql = "SELECT seq, title, content, color, price FROM shoppingmallboard ORDER BY seq DESC";
        int countRows = 0; // 행의 번호

        try {
            pstmt = conn.prepareStatement(selectSql);
            rs = pstmt.executeQuery();

            while(rs.next()) { // sql실행한 데이터들의 1행을 가져옴(데이터가 있으면 true, 없으면 false)
                countRows++; // 행의 개수를 1증가

                System.out.println(
                    String.format("%-10s", rs.getString("seq")) +
                    String.format("%-33s", rs.getString("title")) +
                    String.format("%-40s", rs.getString("content")) +
                    String.format("%-10s", rs.getString("color")) +
                    String.format("%10s", rs.getString("price"))
                );
            }
            if (countRows == 0) { // board테이블에 데이터가 없을 경우
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
	 * @return 상품 번호
	 */
	private int getBoardNo() {
		int boardNo = 0;
		while(true) {
			System.out.println("상품 번호를 입력하세요.> ");
			
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
	 * 설명: 상품 상세조회
	 */
	public void selectOneBoard() {
	    int boardNo = getBoardNo();

	    // 1. 상품의 상세 데이터를 받기 위해 Oracle DB접속준비
	    Connection conn = DBManager.getDBConnection();
	    
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        String countSql = "SELECT COUNT(*) FROM shoppingmallboard WHERE seq = ?";
	        // sql실행(countSql)
	        pstmt = conn.prepareStatement(countSql);
	        pstmt.setInt(1, boardNo);
	        rs = pstmt.executeQuery(); // select 실행(count)

	        if (rs.next()) { // sql실행한 데이터들의 1행을 가져옴(데이터가 있으면 true, 없으면 false)
	            int rowCount = rs.getInt(1); // count(*)값 가져오기
	            
	            if (rowCount == 0) { // 상세조회할 게시글이 없는 경우
	                System.out.println("상세조회할 상품 번호가 없습니다.");
	                return;
	            }
	        }
	        // pstmt와 rs를 닫고 새 쿼리를 실행하기 위해 초기화
	        DBManager.dbClose(null, pstmt, rs);

	        // 2. 상세조회할 sql 코드들 작성
	        String detailSelectSql = "SELECT * FROM shoppingmallboard WHERE seq = ?";
	        // sql 실행(detailSelectSql)
	        pstmt = conn.prepareStatement(detailSelectSql);
	        pstmt.setInt(1, boardNo);
	        rs = pstmt.executeQuery(); // select 실행(detail)
	        
	        if (rs.next()) { // sql 실행한 데이터들의 1행을 가져옴(데이터가 있으면 true, 없으면 false)
	            // 4. sql 실행해서 가져온 데이터들을 자바변수에 세팅 혹은 출력
	            // 5. 상품 상세조회 출력 화면
	            System.out.println("-------------------------------------------------------------");
	            System.out.println("상품 번호: " + rs.getInt("seq"));
	            System.out.println("상품명: " + rs.getString("title"));
	            System.out.println("상품 설명: " + rs.getString("content"));
	            System.out.println("상품 색상: " + rs.getString("color"));
	            System.out.println("상품 가격: " + rs.getString("price"));
	            System.out.println("-------------------------------------------------------------");
	        }
	    } catch(SQLException se) {
	        System.out.println("상품 상세조회 쿼리 실행 오류: " + se.getMessage());
	    } finally {
	        // Oracle DB 접속 관련 객체들 정리
	        DBManager.dbClose(conn, pstmt, rs);
	    }
	}
	
	/**
	 * 설명: 상품 삭제
	 */
	public void deleteOneBoard() {
		System.out.println("삭제할 상품 번호를 입력하세요.> ");
		int boardNo = Integer.parseInt(scanner.nextLine());
		
		// 삭제 더블체크
		System.out.print("정말 " + boardNo + "번 상품을 삭제하시겠습니까? (Y/N)");
		String confirmYN = scanner.nextLine();
		if (!confirmYN.equals("Y"))
			return;

		// 1. 상품의 상세 데이터를 받기 위해 Oracle DB접속준비
		Connection conn = DBManager.getDBConnection();
		
		// 입력한 상품 번호의 개수를 가져오기
		String countSql = "SELECT COUNT(*) FROM shoppingmallboard WHERE seq = ?";
		
		// 상품 특정번호 삭제 sql
		String deleteOneSql = "DELETE FROM shoppingmallboard WHERE seq = ?";
		
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
					System.out.println("삭제할 상품 번호가 없습니다.");
					return;
				}
			}
						
			// sql실행
			pstmt = conn.prepareStatement(deleteOneSql);
			pstmt.setInt(1, boardNo);
			resultRow = pstmt.executeUpdate(); // delete실행

			System.out.println("상품 번호 " + boardNo + "를 성공적으로 삭제하였습니다.");
		} catch(SQLException se) {
			System.out.println("상품 삭제 쿼리 실행 오류: " + se.getMessage());
		} finally {
			// Oracle DB 접속 관련 객체들 정리
			DBManager.dbClose(conn, pstmt, rs);
		}
	}
	
	/**
	 * 설명: 게시글 수정
	 */
	public void updateOneBoard() {
		// 1. 수정할 상품 번호   
	    System.out.println("수정할 상품 번호를 입력하세요.> ");
	    int boardNo = Integer.parseInt(scanner.nextLine());

	    // 입력한 상품 번호의 개수를 가져오기
	    String countSql = "SELECT COUNT(*) FROM shoppingmallboard WHERE seq = ?";

	    // 상품의 상세 데이터를 받기 위해 Oracle DB접속준비
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
	                System.out.println("없는 상품 번호입니다.");
	                return;
	            }
	        }
	    } catch (SQLException se) {
	        System.out.println("상품 번호 개수 쿼리 실행 오류: " + se.getMessage());
	        return;
	    }

	    // 2. 수정할 상품 제목
	    System.out.println("수정할 상품명을 입력하세요.> ");
	    String updateTitle = scanner.nextLine();
	    // 3. 수정할 상품 내용
	    System.out.println("수정할 상품 설명을 입력하세요.> ");
	    String updateContent = scanner.nextLine();
	    // 4. 수정할 상품 색상
	    System.out.println("수정할 상품 색상을 입력하세요.> ");
	    String updateColor = scanner.nextLine();
	    // 5. 수정할 상품 가격
	    System.out.println("수정할 상품 가격을 입력하세요.> ");
	    int updatePrice = Integer.parseInt(scanner.nextLine());

	    // 2. 상품 특정번호 수정 sql
	    String updateOneSql 
	        = "UPDATE shoppingmallboard SET title = ?, content = ?, color = ?, price = ?, update_date = sysdate WHERE seq = ?";

	    try {
	        // 3. sql실행
	        pstmt = conn.prepareStatement(updateOneSql);
	        pstmt.setString(1, updateTitle);
	        pstmt.setString(2, updateContent);
	        pstmt.setString(3, updateColor);
	        pstmt.setInt(4, updatePrice);
	        pstmt.setInt(5, boardNo);
	        resultRow = pstmt.executeUpdate(); // update실행

	        System.out.println("상품 번호 " + boardNo + "를 성공적으로 수정하였습니다.");
	    } catch (SQLException se) {
	        System.out.println("상품 수정 쿼리 실행 오류: " + se.getMessage());
	    } finally {
	        // Oracle DB 접속 관련 객체들 정리
	        DBManager.dbClose(conn, pstmt, rs);
	    }
	}
}
