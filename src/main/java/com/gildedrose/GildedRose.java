package com.gildedrose;

class GildedRose {
    GildedRoseConstants constants;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(GildedRoseConstants.AGED_BRIE)
                && !item.name.equals(GildedRoseConstants.BACKSTAGE_PASSES)) {
                if (item.quality > 0) {
                    if (!item.name.equals(GildedRoseConstants.HAND_OF_RAGNAROS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(GildedRoseConstants.BACKSTAGE_PASSES)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(GildedRoseConstants.HAND_OF_RAGNAROS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(GildedRoseConstants.AGED_BRIE)) {
                    if (!item.name.equals(GildedRoseConstants.BACKSTAGE_PASSES)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(GildedRoseConstants.HAND_OF_RAGNAROS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
