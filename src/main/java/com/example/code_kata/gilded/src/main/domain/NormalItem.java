package com.example.code_kata.gilded.src.main.domain;

import com.example.code_kata.gilded.src.main.domain.Item;

/**
 * packageName    : com.example.code_kata.gilded.src.main
 * fileName       : NormalItem
 * author         : JAEIK
 * date           : 4/4/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/4/26        JAEIK       최초 생성
 */
public class NormalItem extends Item {
    @Override
    public void updateQuality() {
        if (sellIn <= 0) {
            quality -= 2;
        } else {
            quality--;
        }

        if (quality < 0) {
            System.out.println("음수로 떨어 질 수 없습니다");
            quality = 0;
        }
    }

    public NormalItem() {
    }

    public NormalItem(int sellIn, int quality) {
        super(sellIn, quality);
    }
}
