package lecture0722.step4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private ConnectionMaker ndao;
    public UserDAO(){
        ConnectionMaker ndao = new NUserDAO();
    }

    public void insert(User user) throws ClassNotFoundException, SQLException {

        Connection conn = ndao.makeConnection();

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

        Connection conn = ndao.makeConnection();

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
