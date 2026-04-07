package com.example.code_kata.gilded.src.main.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.example.code_kata.gilded.src.main.domain
 * fileName       : SulfurasItemTest
 * author         : JAEIK
 * date           : 4/7/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/7/26        JAEIK       최초 생성
 */
class SulfurasItemTest {

    @Test
    void 업데이트해도_Quality_80고정() {
        SulfurasItem sfi = new SulfurasItem();

        sfi.updateQuality();

        assertEquals(80, sfi.getQuality());
    }
}