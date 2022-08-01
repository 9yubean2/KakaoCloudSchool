package board.dao;

import board.vo.Board;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {

    private DataSource ds;

    public BoardDAO() throws Exception {

        Context init = new InitialContext();
        ds = (DataSource)init.lookup("java:comp/env/jdbc/MySQLDB");

    }

    public Board update(Board board) throws SQLException {

        Connection conn = ds.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql =  "UPDATE boardTbl SET hits = ? WHERE boardId = ?";

        pstmt = conn.prepareStatement(sql);
        //PreparedStatement pstmt2 = conn.prepareStatement(sql2);

        pstmt.setInt(1,board.getHits()+1);
        pstmt.setInt(2, board.getBoardId());

        pstmt.executeUpdate();

        Board result = search(board);

        while (rs.next()){

            result.setBoardId(rs.getInt("boardId"));
            result.setBoardTitle(rs.getString("boardTitle"));
            result.setMemberId(rs.getString("memberId"));
            result.setBoardContents(rs.getString("boardContents"));
            result.setBoardDate(rs.getString("boardDate"));
            result.setLikes(rs.getInt("likes"));
            result.setHits(rs.getInt("hits"));
            result.setCommentCount(rs.getInt("commentCount"));

        }

        if(rs!=null) rs.close();
        if(pstmt!=null) pstmt.close();
        if(conn!=null) conn.close();

        return result;

    }

    public ArrayList<Board> select () throws SQLException {

        Connection conn = ds.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM boardTbl";

        pstmt = conn.prepareStatement(sql);

        rs = pstmt.executeQuery();

        ArrayList<Board> boardList = new ArrayList<Board>();

        while (rs.next()){

            Board board = new Board();

            board.setBoardId(rs.getInt("boardId"));
            board.setBoardTitle(rs.getString("boardTitle"));
            board.setMemberId(rs.getString("memberId"));
            board.setBoardContents(rs.getString("boardContents"));
            board.setBoardDate(rs.getString("boardDate"));
            board.setLikes(rs.getInt("likes"));
            board.setHits(rs.getInt("hits"));
            board.setCommentCount(rs.getInt("commentCount"));

            boardList.add(board);
        }

        if(rs!=null) rs.close();
        if(pstmt!=null) pstmt.close();
        if(conn!=null) conn.close();

        return boardList;
    }

    public int insert(Board board) throws SQLException {
        Connection conn = ds.getConnection();

        String sql =  "INSERT INTO boardTbl VALUES(NULL,?,?,?,?,0,0,0)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, board.getBoardTitle());
        pstmt.setString(2, board.getMemberId());
        pstmt.setString(3, board.getBoardContents());
        pstmt.setString(4, board.getBoardDate());


        int result = pstmt.executeUpdate();

        if (result==1) {
            return result;
        }
        else {
            return 0;
        }
    }

    public Board search(Board board) throws SQLException {

        Connection conn = ds.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql =  "SELECT * FROM boardTbl WHERE boardId = ? ";
        //String sql2 =  "SELECT * FROM commentTbl WHERE boardId = ? ";

        pstmt = conn.prepareStatement(sql);
        //PreparedStatement pstmt2 = conn.prepareStatement(sql2);

        pstmt.setInt(1, board.getBoardId());

        rs = pstmt.executeQuery();

        Board result = new Board();
        while (rs.next()){

            result.setBoardId(rs.getInt("boardId"));
            result.setBoardTitle(rs.getString("boardTitle"));
            result.setMemberId(rs.getString("memberId"));
            result.setBoardContents(rs.getString("boardContents"));
            result.setBoardDate(rs.getString("boardDate"));
            result.setLikes(rs.getInt("likes"));
            result.setHits(rs.getInt("hits"));
            result.setCommentCount(rs.getInt("commentCount"));

        }

        if(rs!=null) rs.close();
        if(pstmt!=null) pstmt.close();
        if(conn!=null) conn.close();

        return result;
    }
}
