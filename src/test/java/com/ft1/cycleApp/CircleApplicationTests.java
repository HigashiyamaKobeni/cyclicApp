package com.ft1.cycleApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class CircleApplicationTests {
    @Autowired  // auto configuration
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    /**
     * database connection pool:
     * Hikari CP
     * HikariProxyConnection@1704927850 wrapping com.mysql.cj.jdbc.ConnectionImpl@2e463f4
     * throws SQLException
     */
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
