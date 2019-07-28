import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
        public static String driver="com.mysql.jdbc.Driver";
        public static String mysqlUrl="jdbc:mysql://127.0.0.1:3306/test";
        public static String userName="user";
        public static String password="password";
        public static Connection connection;
        public static Statement statement;
        public static void connection() throws ClassNotFoundException, SQLException {
            Class.forName(driver);
            connection=DriverManager.getConnection(mysqlUrl,userName,password);
            statement=connection.createStatement();
        }
        public static void insert() throws SQLException {
            String str="insert into student value (7,'TOM','男',21)";
            statement.executeUpdate(str);
        }
        public static void delete() throws SQLException {
            String str="delete from student where sid = 7";
            statement.executeUpdate(str);
        }
        public static void update(){

        }
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            connection();
//            insert();
            delete();
        }
    }

