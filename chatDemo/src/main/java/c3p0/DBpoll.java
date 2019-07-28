package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBpoll {
    private static DBpoll dBpoll;//单例模式
    private  ComboPooledDataSource dataSourse;//配置数据源
    static {
        dBpoll=new DBpoll();
    }
    private DBpoll(){
        try {
            dataSourse =new ComboPooledDataSource();//数据源的设置
            Properties pro =new Properties();
            pro.load(new FileInputStream("src/db.properties"));
            dataSourse.setDriverClass(pro.getProperty("driver"));
            dataSourse.setUser(pro.getProperty("user"));
            dataSourse.setJdbcUrl(pro.getProperty("jdbcUrl"));
            dataSourse.setPassword(pro.getProperty("password"));
            dataSourse.setMaxPoolSize(Integer.parseInt(pro.getProperty("maxPoolSize")));
            dataSourse.setMinPoolSize(Integer.parseInt(pro.getProperty("minPoolSize")));
            System.out.println(dataSourse);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

    }
    public static DBpoll getdBpoll(){
        return dBpoll;
    }
    public Connection getConnection() throws SQLException {
        return  dataSourse.getConnection();
    }
}
