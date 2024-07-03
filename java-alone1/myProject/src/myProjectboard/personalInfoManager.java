package myProjectboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class personalInfoManager {
	// JDBC URL, 사용자 이름, 비밀번호
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String JDBC_USER = "your_username";
    private static final String JDBC_PASSWORD = "your_password";

    public static void main(String[] args) {
        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // 데이터베이스 연결
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement()) {

            // 테이블 생성 SQL 쿼리
            String createTableSQL = "CREATE TABLE personal_info (" +
                    "id CHAR(12) PRIMARY KEY, " +
                    "password CHAR(12) NOT NULL, " +
                    "name CHAR(10) NOT NULL, " +
                    "date_of_birth DATE NOT NULL, " +
                    "phone_number CHAR(13) NOT NULL UNIQUE, " +
                    "email CHAR(32) NOT NULL UNIQUE" +
                    ")";

            // 테이블 생성 실행
            statement.execute(createTableSQL);

            System.out.println("Table 'personal_info' is created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
