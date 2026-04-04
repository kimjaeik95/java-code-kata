package com.example.code_kata.gilded.src.main.domain;

import lombok.Getter;

/**
 * packageName    : com.example.code_kata.gilded.src.main
 * fileName       : Item
 * author         : JAEIK
 * date           : 4/4/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/4/26        JAEIK       최초 생성
 */
@Getter
public class Item {

    // 남은기간
    public int sellIn;

    // 아이템 가치
    public int quality;


    public void updateQuality() {

    }

    public void decreaseSellIn() {
        this.sellIn--;
    }

    public Item() {

    }

    public Item(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }
}
