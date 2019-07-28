package com.tulun.tuluntest.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@MapperScan("com.tulun.tuluntest.config.dao")
public class DataSourceConfiguration {
    private static final Logger logger = Logger.getLogger(String.valueOf(DataSourceConfiguration.class));

    @Value("${jdbc.driver}")
    private String jdbcDriver;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String jdbcUserName;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    /*连接池信息从配置文件中读取*/
    @Value("${c3p0.initializeSize}")
    private Integer initializeSize;

    @Value("${c3p0.maxSize}")
    private Integer maxSize;

    @Value("${c3p0.maxIdleTime}")
    private Integer maxIdleTime;


    @Bean(name="dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setPassword(jdbcPassword);
        dataSource.setUser(jdbcUserName);

        /*分别添加连接池的初始连接数量， 最大连接数量，以及最大空闲时间的参数*/
        dataSource.setInitialPoolSize(initializeSize);
        dataSource.setMaxPoolSize(maxSize);
        dataSource.setMaxIdleTime(maxIdleTime);

        //关闭连接后不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
