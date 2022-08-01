package board.dao;

import board.vo.Board;
import board.vo.Comment;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentDAO {

    private DataSource ds;

    public CommentDAO() throws Exception {

        Context init = new InitialContext();
        ds = (DataSource)init.lookup("java:comp/env/jdbc/MySQLDB");

    }
    public ArrayList<Comment> select (int boardId) throws SQLException {

        Connection conn = ds.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM commentTbl WHERE boardId = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,boardId);

        rs = pstmt.executeQuery();

        ArrayList<Comment> commentList = new ArrayList<Comment>();

        while (rs.next()){

            Comment comment = new Comment();

            comment.setBoardId(rs.getInt("boardId"));
            comment.setMemberId(rs.getString("memberId"));
            comment.setCommentContents(rs.getString("commentContents"));

            commentList.add(comment);
        }

        if(rs!=null) rs.close();
        if(pstmt!=null) pstmt.close();
        if(conn!=null) conn.close();

        return commentList;
    }

    public int insert(Comment comment) throws SQLException {

        Connection conn = ds.getConnection();

        String sql =  "INSERT INTO commentTbl VALUES(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, comment.getBoardId());
        pstmt.setString(2, comment.getMemberId());
        pstmt.setString(3, comment.getCommentContents());

        int result = pstmt.executeUpdate();

        if (result==1) {
            return result;
        }
        else {
            return 0;
        }
    }
}
