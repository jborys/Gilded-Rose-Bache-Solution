package com.gildedrose;

import static com.gildedrose.GildedRoseConstants.AGED_BRIE;
import static com.gildedrose.GildedRoseConstants.MAX_QUALITY;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super(AGED_BRIE, sellIn, quality);
    }

    @Override
    void updateItems() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality < MAX_QUALITY) {
                quality = quality + 1;
            }
        }

    }
}
