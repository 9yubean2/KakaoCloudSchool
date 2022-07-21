package lecture0721.simplebooksearch.dao;
import lecture0721.simplebooksearch.vo.*;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

//DB 처리
//로직 처리하면 안돼요 insert, select, delete, update등의 단일 db access 기능
public class BookDAO {
    public static BasicDataSource basicDS;

    public BookDAO(){
        try {

            basicDS = new BasicDataSource();
            Properties properties = new Properties();

            InputStream is = new FileInputStream("properties/db.properties");
            properties.load(is);

            basicDS.setDriverClassName(properties.getProperty("DRIVER_CLASS"));
            basicDS.setUrl(properties.getProperty("JDBC_URL"));
            basicDS.setUsername(properties.getProperty("DB_USER"));
            basicDS.setPassword(properties.getProperty("DB_PASSWORD"));

            basicDS.setInitialSize(10);
            basicDS.setMaxTotal(10);

        } catch (Exception e){
            //TODO: handle exception
        }
    }

    public static DataSource getDataSource(){
        return basicDS;
    }

    public ArrayList<BookVO> select (String keyword){
        ArrayList<BookVO> list = null;

        Connection conn = null;
        DataSource ds = getDataSource();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = ds.getConnection();

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



        } catch (Exception e2){
            System.out.println(e2);
        } finally {
            try {
                //6. 사용한 자원 해제
                if(rs!=null) rs.close();
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();

            } catch (SQLException e3) {
                System.out.println(e3);
            }
        }
        return list;
    }

    public String delete(String bisbn){

        String resStatus;

        Connection conn = null;
        DataSource ds = getDataSource();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);

            String sql = "DELETE FROM book WHERE bisbn = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,bisbn);

            int result = pstmt.executeUpdate();

            conn.commit();
            resStatus = "[삭제 성공]";

        } catch (Exception e2){
            //TODO: handle exception
            resStatus = "[삭제 실패]";
            return resStatus;
        } finally {
            try {
                //6. 사용한 자원 해제
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();

            } catch (SQLException e3) {
                System.out.println(e3);
            }
        }
        return resStatus;
    }
}
