package com.wong;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoApplicationTests {

	//DI注入數據源
    @Autowired
    DataSource dataSource;
    
    @Test
    public void contextLoads() throws SQLException {
        //看一下默認數據源
    	// class com.alibaba.druid.pool.DruidDataSource
        System.out.println(dataSource.getClass()); 
        //獲得連接
        Connection connection = dataSource.getConnection();
        // com.mysql.cj.jdbc.ConnectionImpl@6a4ccef7
        System.out.println(connection); 

        //關閉連接
        connection.close();
    }

}
