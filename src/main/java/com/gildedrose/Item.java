package com.gildedrose;

import static com.gildedrose.GildedRoseConstants.*;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item createItem(String name, int sellIn, int quality) {
        switch (name) {
            case AGED_BRIE:
                return new AgedBrie(sellIn, quality);
            case BACKSTAGE_PASSES:
                return new BackstagePasses(sellIn, quality);
            case HAND_OF_RAGNAROS:
                return new HandOfRagnaros(sellIn, quality);
            default:
                return new Item(name, sellIn, quality);
        }
    }


    @Override
    public String toString() {
        return "Item{" +
            "name='" + name + '\'' +
            ", sellIn=" + sellIn +
            ", quality=" + quality +
            '}';
    }

    void updateItems() {
        if (quality > 0) {
            quality = quality - 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality > 0) {
                quality = quality - 1;
            }
        }
    }
}
