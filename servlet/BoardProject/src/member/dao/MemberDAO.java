package member.dao;

import member.vo.Member;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    private DataSource ds;

    public MemberDAO() throws Exception {

        Context init = new InitialContext();
        ds = (DataSource)init.lookup("java:comp/env/jdbc/MySQLDB");

    }


    public Member selectMember(Member member) throws SQLException {

        Connection conn = ds.getConnection();

        String sql =  "SELECT * FROM memberTbl WHERE memberId = ? AND  memberPw = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, member.getMemberId());
        pstmt.setString(2, member.getMemberPw());

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            Member result = new Member(rs.getString("memberId"),rs.getString("memberPw"),rs.getString("memberName"));
            return result;
        }
        else {
            return null;
        }
    }

    public int insertMember(Member member) throws SQLException {

        Connection conn = ds.getConnection();

        String sql =  "INSERT INTO memberTbl VALUES (?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, member.getMemberId());
        pstmt.setString(2, member.getMemberPw());
        pstmt.setString(3, member.getMemberName());

        int result = pstmt.executeUpdate();

        if (result==1) {
            return result;
        }
        else {
            return 0;
        }
    }
}
