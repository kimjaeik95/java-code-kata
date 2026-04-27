package com.example.code_kata.bank.src.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * packageName    : com.example.code_kata.bank.src.main
 * fileName       : BankApplication
 * author         : JAEIK
 * date           : 4/27/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/27/26        JAEIK       최초 생성
 */
@SpringBootApplication
@EnableScheduling
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }
}
