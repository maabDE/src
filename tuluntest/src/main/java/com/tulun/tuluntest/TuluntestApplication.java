package com.tulun.tuluntest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TuluntestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TuluntestApplication.class, args);
    }

}
