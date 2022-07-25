package lecture0722.step5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDAO implements ConnectionMaker {
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String jdbc_URL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        String jdbc_user = "root";
        String jdbc_password = "mi59659398@";

        Connection conn = DriverManager.getConnection(jdbc_URL, jdbc_user, jdbc_password);

        return conn;
    }
}
