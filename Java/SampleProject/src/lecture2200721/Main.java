package lecture2200721;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            //1. JDBC Driver Loading
            //MySQL 8.0부터는 아래의 class를 사용
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loading SUCCESS!!");

            //2. DBMS와 연결(실제로 데이터베이스 연결)
            String url = "jdbc:mysql://localhost:3306/employees";
            String userName = "root";
            String password = "mi59659398@";

            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("DB Connection SUCCESS!!");

        } catch (ClassNotFoundException e1) {
            System.out.println("Driver Loading FAIL....");
            System.out.println(e1);
        } catch (SQLException e2) {
            System.out.println("DB Connection FAIL....");
            System.out.println(e2);
        }
    }
}
