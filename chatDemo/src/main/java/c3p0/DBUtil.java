package c3p0;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        DBpoll dBpoll=DBpoll.getdBpoll();
        return  dBpoll.getConnection();
    }
}
