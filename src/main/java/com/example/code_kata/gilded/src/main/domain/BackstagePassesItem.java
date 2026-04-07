package com.example.code_kata.gilded.src.main.domain;

import com.example.code_kata.gilded.src.main.domain.Item;

/**
 * packageName    : com.example.code_kata.gilded.src.main
 * fileName       : BackstagePassesItem
 * author         : JAEIK
 * date           : 4/4/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/4/26        JAEIK       최초 생성
 */
public class BackstagePassesItem extends Item {
    @Override
    public void updateQuality() {
        if (sellIn > 10) { // 30 > 10
            quality++;
        } else if (sellIn > 5) { // 10 >  5
            quality += 2;
        } else if (sellIn > 0) { // 5 > 1
            quality += 3;
        } else { // 판매종료
            quality = 0;
        }

        if (quality > 50) {
            System.out.println("값은 50을 초과 할 수 없습니다.");
            quality = 50;
        }
    }

    public BackstagePassesItem() {
    }

    public BackstagePassesItem(int sellIn, int quality) {
        super(sellIn, quality);
    }
}
