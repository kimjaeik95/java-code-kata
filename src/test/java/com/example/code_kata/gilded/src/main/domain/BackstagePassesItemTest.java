package com.example.code_kata.gilded.src.main.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.example.code_kata.gilded.src.main.domain
 * fileName       : BackstagePassesItemTest
 * author         : JAEIK
 * date           : 4/7/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/7/26        JAEIK       최초 생성
 */
class BackstagePassesItemTest {

    @Test
    void sellIn_수에맞게_Quality확인() {
        BackstagePassesItem bpi = new BackstagePassesItem(11, 30);
        BackstagePassesItem bpi2 = new BackstagePassesItem(6, 30);
        BackstagePassesItem bpi3 = new BackstagePassesItem(1, 30);
        BackstagePassesItem bpi4 = new BackstagePassesItem(0, 30);


        bpi.updateQuality();
        bpi2.updateQuality();
        bpi3.updateQuality();
        bpi4.updateQuality();

        assertEquals(31, bpi.getQuality()); // 1증가
        assertEquals(32, bpi2.getQuality()); // 2증가
        assertEquals(33, bpi3.getQuality()); // 3증가
        assertEquals(0, bpi4.getQuality()); // 판매종료 확인
    }

}