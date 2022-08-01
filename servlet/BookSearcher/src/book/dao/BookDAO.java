package book.dao;

import book.vo.Book;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
    private DataSource ds;

    public BookDAO() throws Exception {

        Context init = new InitialContext();
        ds = (DataSource)init.lookup("java:comp/env/jdbc/MySQLDB");

    }

    public ArrayList<Book> select (String keyword) throws SQLException {

        Connection conn = ds.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT bisbn, btitle, bauthor, bprice, bimgurl FROM book WHERE btitle LIKE ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,keyword);

        rs = pstmt.executeQuery();

        ArrayList<Book> bookList = new ArrayList<Book>();

        while (rs.next()){

            Book book = new Book();

            book.setBisbn(rs.getString("bisbn"));
            book.setBtitle(rs.getString("btitle"));
            book.setBauthor(rs.getString("bauthor"));
            book.setBprice(rs.getInt("bprice"));
            book.setBimgurl(rs.getString("bimgurl"));

            bookList.add(book);
        }

        if(rs!=null) rs.close();
        if(pstmt!=null) pstmt.close();
        if(conn!=null) conn.close();

        return bookList;
    }

    public int delete (String isbn) throws SQLException {

        Connection conn = ds.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "DELETE FROM book WHERE bisbn = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,isbn);

        int result = pstmt.executeUpdate();


        if(pstmt!=null) pstmt.close();
        if(conn!=null) conn.close();

        return result;
    }


}
