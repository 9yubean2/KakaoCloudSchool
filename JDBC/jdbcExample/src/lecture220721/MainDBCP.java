package lecture220721;


import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MainDBCP {
    private static BasicDataSource basicDS;

    static  {
        //main method 이전에 불러올 data들
        try {

            basicDS = new BasicDataSource();
            Properties properties = new Properties();

            InputStream is = new FileInputStream("resources/db.properties");
            properties.load(is);

            basicDS.setDriverClassName(properties.getProperty("DRIVER_CLASS"));
            basicDS.setUrl(properties.getProperty("JDBC_URL"));
            basicDS.setUsername(properties.getProperty("DB_USER"));
            basicDS.setPassword(properties.getProperty("DB_PASSWORD"));

            // 어떻게 설정해야 하나요?
            basicDS.setInitialSize(10);
            basicDS.setMaxTotal(10);

        } catch (Exception e){
            //TODO: handle exception
        }
    }


    public static DataSource getDataSource(){
        return basicDS;
    }

    public static void main(String[] args) {
        Connection conn = null;
        DataSource ds = getDataSource();
        PreparedStatement pstmt = null;

        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);

            String sql = "DELETE FROM buytbl";
            pstmt = conn.prepareStatement(sql);

            int result = pstmt.executeUpdate();

            conn.commit();
            conn.close();
        } catch (Exception e){
            //TODO: handle exception
        }
    }
}
