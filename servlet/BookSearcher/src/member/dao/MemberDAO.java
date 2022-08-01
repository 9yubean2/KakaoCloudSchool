package member.dao;

import member.vo.Member;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class MemberDAO {

    private DataSource ds;

    public MemberDAO() throws Exception{

        Context init = new InitialContext();
        ds = (DataSource)init.lookup("java:comp/env/jdbc/MySQLDB");

    }

    public Member select(Member member) throws Exception {
        Connection conn = ds.getConnection();
        System.out.println("Connection SUCCESS!!");

        String sql =  "SELECT * FROM members WHERE id = ? AND  pw = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, member.getId());
        pstmt.setString(2, member.getPw());

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Member result = new Member(rs.getString("id"),rs.getString("pw"),rs.getString("name"));
            return result;
        }
        else {
            return null;
        }

    }
}
