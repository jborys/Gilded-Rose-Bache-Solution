package com.gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    public static final int TIER_ONE = 11;
    public static final int TIER_TWO = 6;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) performUpdateItem(item);
    }

    private void performUpdateItem(Item item) {
        switch (item.name) {
            case GildedRoseConstants.AGED_BRIE:
                incrementQuality(item);

                decrementQuality(item);

                if (item.sellIn < 0) {
                    incrementQuality(item);
                }
                break;
            case GildedRoseConstants.BACKSTAGE_PASSES:
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < TIER_ONE) {
                        incrementQuality(item);
                    }

                    if (item.sellIn < TIER_TWO) {
                        incrementQuality(item);
                    }
                }

                decrementQuality(item);

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                break;
            case GildedRoseConstants.HAND_OF_RAGNAROS:
                //Does not change. It is magical.
                break;
            default:
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }

                decrementQuality(item);

                if (item.sellIn < 0) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 2;
                    }
                }
                break;
        }
    }

    private void decrementQuality(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void incrementQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

}
