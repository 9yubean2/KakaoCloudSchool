package lecture0722.step1;

import java.sql.*;

public class UserDAO {

    protected Connection dbConnector() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String jdbc_URL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        String jdbc_user = "root";
        String jdbc_password = "mi59659398@";

        Connection conn = DriverManager.getConnection(jdbc_URL, jdbc_user, jdbc_password);
        return conn;
    }

    public void insert(User user) throws ClassNotFoundException, SQLException { //try-catch 사용하지 않아요

        Connection conn = dbConnector();

        String sql = "INSERT INTO users VALUES (?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());

        //insert니까 executeUpdate()
        pstmt.executeUpdate();

        //자원해제
        pstmt.close();
        conn.close();

    }

    public User select(String id) throws ClassNotFoundException, SQLException{

        Connection conn = dbConnector();

        String sql = "SELECT  * FROM users WHERE id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, id);

        //select니까 executeQuery()
        ResultSet rs = pstmt.executeQuery();
        rs.next();

        User user = new User();

        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        //자원해제
        rs.close();
        pstmt.close();
        conn.close();

        return user;
    }
}
