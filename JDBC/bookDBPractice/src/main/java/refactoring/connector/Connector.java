package refactoring.connector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface Connector {
    public abstract Connection makeConnection() throws SQLException, ClassNotFoundException, IOException;
}
