package com.example.code_kata.bank.src.main.config;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * packageName    : com.example.code_kata.bank.src.main.config
 * fileName       : JdbcConfig
 * author         : JAEIK
 * date           : 4/27/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/27/26        JAEIK       최초 생성
 */
@Configuration
public class JdbcConfig {
    private static final String URI = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI, USER, PASSWORD);
    }
}
