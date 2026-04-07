package com.example.code_kata.gilded.src.main.domain;

import com.example.code_kata.gilded.src.main.domain.Item;
import lombok.Getter;

/**
 * packageName    : com.example.code_kata.gilded.src.main
 * fileName       : AgedBrieItem
 * author         : JAEIK
 * date           : 4/4/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/4/26        JAEIK       최초 생성
 */
@Getter
public class AgedBrieItem extends Item {

    // 오래된 브리치즈는 시간이 지날수록 Quality 가 올라감

    @Override
    public void updateQuality() {
        this.quality++;

        if (this.quality > 50) {
            System.out.println("값은 50을 초과 할 수 없습니다.");
            quality = 50;
        }
    }

    public AgedBrieItem() {
    }

    public AgedBrieItem(int sellIn, int quality) {
        super(sellIn, quality);
    }
}

