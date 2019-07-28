package NettyDemo.dao;
import NettyDemo.entity.User;
import NettyDemo.entity.chatRoomType;
import NettyDemo.service.IMP.ConnectMySQL;
import com.mysql.jdbc.MySQLConnection;

import java.sql.*;
import java.util.Scanner;

/*dao层只能出现sql语句
 */
public class user {
    String name;
    String password;
    PreparedStatement psm =null;//sql
    Connection connection =null;
    /**
     *
     */
    //用户注册
    public  void insert(String name,String password){
        //sql语句
        try {
            connection=ConnectMySQL.getConnection();
            String sql="insert into admin(name,password) values(?,?);";
            psm=connection.prepareStatement(sql);
            psm.setString(1,name);
            psm.setString(2,password);
            psm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                psm.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //用户登陆
    public void select(String name,String password){
        try {
            connection=ConnectMySQL.getConnection();
            String sql="select name,password from admin where name=?  and password=?";
            psm=connection.prepareStatement(sql);
            psm.setString(1, name);
            psm.setString(2,password);
            psm.execute();
            ResultSet rs=psm.getResultSet();
            if (rs.next()){
                this.name=name;
                this.password=password;
                System.out.println("登陆成功，欢迎用户"+name+"!/n");
            }
            else {
                System.out.println("登陆失败，请核对用户名密码");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                psm.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
