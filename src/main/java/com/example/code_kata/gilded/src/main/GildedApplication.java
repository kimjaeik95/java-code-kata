package com.example.code_kata.gilded.src.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * packageName    : com.example.code_kata.gilded.src.main
 * fileName       : GildedApplication
 * author         : JAEIK
 * date           : 4/4/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/4/26        JAEIK       최초 생성
 */
@SpringBootApplication
@EnableScheduling
public class GildedApplication {
    public static void main(String[] args) {
        SpringApplication.run(GildedApplication.class, args);
    }
}
