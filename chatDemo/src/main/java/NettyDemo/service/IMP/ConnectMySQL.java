package NettyDemo.service.IMP;

import java.sql.*;
import java.util.Properties;

public class ConnectMySQL {
    /*
    * 1.处理数据库的连接
    * 2.获得PreparedStatement*/
//    public static Properties pro=new Properties();
//    public  static String driver=pro.getProperty("driver");
//    public  static String url= pro.getProperty("jdbcUrl");
//    public  static String username=pro.getProperty("root");
//    public  static String password=pro.getProperty("password");
    public  static Connection connection=null;
    public static PreparedStatement pst=null;
    public static ResultSet rs=null;
    public static int i;
       public static Connection getConnection() throws SQLException, ClassNotFoundException {
           Class.forName("com.mysql.jdbc.Driver");
           return connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chatroom","root","password");
    }

//    public static void main(String[] args) throws SQLException {
//        try {
//            Connection c=getConnection();
//            System.out.println(c);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }

}
