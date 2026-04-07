package com.example.code_kata.gilded.src.main.domain;

/**
 * packageName    : com.example.code_kata.gilded.src.main.domain
 * fileName       : ConjuredItem
 * author         : JAEIK
 * date           : 4/4/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/4/26        JAEIK       최초 생성
 */
public class ConjuredItem extends Item {
    public ConjuredItem() {
    }

    public ConjuredItem(int sellIn, int quality) {
        super(sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (sellIn <= 0) {
            quality -= 2 * 2;
        } else {
            quality -= 2;
        }

        if (quality < 0) {
            System.out.println("음수로 떨어 질 수 없습니다.");
            quality = 0;
        }


    }
}
