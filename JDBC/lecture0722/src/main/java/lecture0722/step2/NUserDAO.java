package lecture0722.step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//naver쪽 개발자가 UserDAO를 이용하기 위해
//sub class를 작성
public class NUserDAO extends UserDAO{
    @Override
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String jdbc_URL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        String jdbc_user = "root";
        String jdbc_password = "mi59659398@";

        Connection conn = DriverManager.getConnection(jdbc_URL, jdbc_user, jdbc_password);
        return conn;
    }
}
