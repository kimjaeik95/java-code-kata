package com.example.code_kata.gilded.src.main.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.example.code_kata.gilded.src.main.domain
 * fileName       : AgedBrieItemTest
 * author         : JAEIK
 * date           : 4/4/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/4/26        JAEIK       최초 생성
 */
class AgedBrieItemTest {
    @Test
    void 하루가_지나면_Quality가_증가 () {

        AgedBrieItem item = new AgedBrieItem(10, 20);

        item.decreaseSellIn();
        item.updateQuality();

        assertEquals(21, item.getQuality());
    }
    @Test
    void Quality가_맥스_Quality_초과오류확인() {

        AgedBrieItem item = new AgedBrieItem(10, 50);

        item.decreaseSellIn();
        item.updateQuality();

        assertTrue(item.getQuality() <= 50);

    }

}