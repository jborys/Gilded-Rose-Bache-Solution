package com.gildedrose;

import static com.gildedrose.GildedRoseConstants.HAND_OF_RAGNAROS;

public class HandOfRagnaros extends Item {
    public HandOfRagnaros(int sellIn, int quality) {
        super(HAND_OF_RAGNAROS, sellIn, quality);
    }

    @Override
    void updateItems() {
        //Do Nothing if Ragnaros
    }
}
