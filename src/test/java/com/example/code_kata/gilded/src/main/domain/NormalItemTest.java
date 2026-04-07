package com.example.code_kata.gilded.src.main.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.example.code_kata.gilded.src.main.domain
 * fileName       : NormalItemTest
 * author         : JAEIK
 * date           : 4/4/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/4/26        JAEIK       최초 생성
 */
class NormalItemTest {

    @Test
    void 정상적으로_SeIIN_Quality_마이너스_1_확인() {
        NormalItem item = new NormalItem(10,20);

        item.decreaseSellIn();
        item.updateQuality();

        assertEquals(19, item.getQuality());
        assertEquals(9, item.getSellIn());
    }

    @Test
    void 실패_SeIIN_Quality_마이너스_1_확인() {
        NormalItem item = new NormalItem(10,20);

        item.decreaseSellIn();
        item.updateQuality();

        assertNotEquals(20, item.quality);
        assertNotEquals(10, item.getSellIn());
        assertTrue(item.quality >= -1);
    }

}