package refactoring;

import org.apache.commons.dbcp2.BasicDataSource;
import refactoring.connector.Connector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MyDAO implements Connector {
    @Override
    public Connection makeConnection() throws SQLException, ClassNotFoundException, IOException {

        BasicDataSource basicDS = new BasicDataSource();
        Properties properties = new Properties();

        InputStream is = new FileInputStream("properties/db.properties");
        properties.load(is);

        basicDS.setDriverClassName(properties.getProperty("DRIVER_CLASS"));
        basicDS.setUrl(properties.getProperty("JDBC_URL"));
        basicDS.setUsername(properties.getProperty("DB_USER"));
        basicDS.setPassword(properties.getProperty("DB_PASSWORD"));

        basicDS.setInitialSize(10);
        basicDS.setMaxTotal(10);
        Connection conn = basicDS.getConnection();

        return conn;
    }
}
