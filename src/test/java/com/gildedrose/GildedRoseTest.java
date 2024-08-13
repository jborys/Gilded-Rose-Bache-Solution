package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRoseConstants.*;

class GildedRoseTest {

    @Test
    void foo() throws Exception {
        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality,
            new String[] {"foo", AGED_BRIE, BACKSTAGE_PASSES, HAND_OF_RAGNAROS},
            new Integer[] {-2, 0, 4, 6, 12},
            new Integer[] {0, 1, 49, 55}
        );
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }

}
