package com.example.code_kata.gilded.src.main.service;

import com.example.code_kata.gilded.src.main.domain.AgedBrieItem;
import com.example.code_kata.gilded.src.main.domain.BackstagePassesItem;
import com.example.code_kata.gilded.src.main.domain.NormalItem;
import com.example.code_kata.gilded.src.main.domain.SulfurasItem;
import com.example.code_kata.gilded.src.main.domain.Item;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * packageName    : com.example.code_kata.gilded.src.main
 * fileName       : Gilded
 * author         : JAEIK
 * date           : 4/4/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/4/26        JAEIK       최초 생성
 */

@Component
public class GildedSystem {
    private List<Item> items = new ArrayList<>();

    public GildedSystem() {
        items.addAll(Arrays.asList(
                new AgedBrieItem(),
                new BackstagePassesItem(),
                new NormalItem(),
                new SulfurasItem()));
    }

    @Scheduled(fixedRate = 86400000)
    public void schedulerItem() {
        for (Item item : items) {
            item.decreaseSellIn();
            item.updateQuality();
        }
    }
}
