package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRoseConstants.*;

class GildedRoseTest {

    @Test
    void foo() throws Exception {
        CombinationApprovals.verifyAllCombinations(
            this::performUpdateQuality,
            new String[] {"foo", AGED_BRIE, BACKSTAGE_PASSES, HAND_OF_RAGNAROS},
            new Integer[]{-1, 0, 5, 10, 11 },
            new Integer[]{0, 1, 49, 55}
        );
    }

    private Item performUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] {Item.createItem(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        Item item = app.items[0];
        app.updateQuality();
        return item;
    }

}
