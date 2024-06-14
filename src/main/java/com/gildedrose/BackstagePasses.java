package com.gildedrose;

import static com.gildedrose.GildedRoseConstants.*;

public class BackstagePasses extends Item {
    public BackstagePasses(int sellIn, int quality) {
        super(BACKSTAGE_PASSES, sellIn, quality);
    }

    @Override
    void updateItems() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;

            if (sellIn < SELL_IN_TIER_ONE) {
                if (quality < MAX_QUALITY) {
                    quality = quality + 1;
                }
            }

            if (sellIn < SELL_IN_TIER_TWO) {
                if (quality < MAX_QUALITY) {
                    quality = quality + 1;
                }
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }
    }
}
