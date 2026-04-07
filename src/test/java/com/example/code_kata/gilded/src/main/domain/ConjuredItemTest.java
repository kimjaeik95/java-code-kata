package com.example.code_kata.gilded.src.main.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.example.code_kata.gilded.src.main.domain
 * fileName       : ConjuredItemTest
 * author         : JAEIK
 * date           : 4/7/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/7/26        JAEIK       최초 생성
 */
class ConjuredItemTest {

    @Test
    void sellIn_하루지날떄마다_Quality_마이너스2_판매종료되면2배떨어짐() {
        ConjuredItem ci = new ConjuredItem(10,30);
        ConjuredItem ci2 = new ConjuredItem(0,30);

        ci.updateQuality();
        ci2.updateQuality();

        assertEquals(28, ci.getQuality()); // 2씩 떨어짐
        assertEquals(26, ci2.getQuality()); // 2 * 2 배 떨어짐
    }

}