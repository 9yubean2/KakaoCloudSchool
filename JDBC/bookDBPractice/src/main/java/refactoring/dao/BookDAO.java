package refactoring.dao;

import refactoring.connector.Connector;
import refactoring.vo.BookVO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {

    private Connector connector;

    public BookDAO(Connector connector){
       this.connector = connector;
    }

    public ArrayList<BookVO> select (String keyword) throws SQLException, ClassNotFoundException, IOException {

        ArrayList<BookVO> list = null;

        Connection conn = connector.makeConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT btitle,bauthor,bisbn FROM book WHERE btitle LIKE ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,keyword);

        rs = pstmt.executeQuery();
        list = new ArrayList<BookVO>();

        while (rs.next()){
            BookVO tmp = new BookVO();

            tmp.setBtitle(rs.getString(1));
            tmp.setBauthor(rs.getString(2));
            tmp.setBisbn(rs.getString(3));

            list.add(tmp);
        }


        return list;
    }

    public String delete(String bisbn) throws SQLException, ClassNotFoundException, IOException {

        String resStatus;

        Connection conn = connector.makeConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn.setAutoCommit(false);

        String sql = "DELETE FROM book WHERE bisbn = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,bisbn);

        int result = pstmt.executeUpdate();

        conn.commit();

        if (result == 0){

            resStatus = "[삭제 실패]";

            return resStatus;
        }
        else{

            resStatus = "[삭제 성공]";

            return resStatus;
        }

    }
}
