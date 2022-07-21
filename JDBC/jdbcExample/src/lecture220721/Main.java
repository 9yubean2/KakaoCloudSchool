package lecture220721;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            //1. JDBC Driver Loading
            //MySQL 8.0부터는 아래의 class를 사용
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loading SUCCESS!!"+"\n");

            //2. DBMS와 연결(실제로 데이터베이스 연결)
            String jdbcURL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
            String userName = "root";
            String password = "mi59659398@";

            conn = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("DB Connection SUCCESS!!"+"\n");

            conn.setAutoCommit(false); // Transaction 시작

            //3. Statement 생성
            //prepared statement는 in parameter 사용 가능
            String sql = "DELETE FROM buytbl WHERE userId = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"BBK");

            //4.Query 실행
            int result = pstmt.executeUpdate();

            System.out.println("총" +result+ "개의 행이 삭제되었습니다.");

            conn.rollback(); // Transaction 종료(무효화) -- 명시 권장

        } catch (ClassNotFoundException e1) {

            System.out.println("Driver Loading FAIL....");
            System.out.println(e1);

        } catch (SQLException e2) {

            System.out.println("DB Connection FAIL....");
            System.out.println(e2);

        } finally {
            try {

                //6. 사용한 자원 해제
                if(pstmt!=null) pstmt.close();
                if(conn!=null) {
                    conn.close();
                    System.out.println("\n"+"=======Connection Close======");
                }

            } catch (SQLException e3) {

                System.out.println(e3);

            }
        }
    }
}
