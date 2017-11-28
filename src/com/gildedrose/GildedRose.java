// ***************************************************************************
// Copyright (c) 2016, Industrial Logic, Inc., All Rights Reserved.
//
// This code is the exclusive property of Industrial Logic, Inc. It may ONLY be
// used by students during Industrial Logic's workshops or by individuals
// who are being coached by Industrial Logic on a project.
//
// This code may NOT be copied or used for any other purpose without the prior
// written consent of Industrial Logic, Inc.
// ****************************************************************************

package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];

            if (isRegularItem(currentItem)) {
                if (currentItem.quality > 0) {
                    currentItem.quality = currentItem.quality - 1;
                }
            }

            if (!isRegularItem(currentItem)) {
                if (currentItem.quality < 50) {
                    currentItem.quality = currentItem.quality + 1;

                    if (currentItem.name.equals(BACKSTAGE_PASSES)) {
                        decreaseBackstagePassQuality(currentItem);
                    }
                }
            }

            reduceSellInExceptSulfuras(currentItem);

            if (currentItem.sellIn < 0) {

                if (currentItem.name.equals(AGED_BRIE)) {
                    if (currentItem.quality < 50) {
                        currentItem.quality = currentItem.quality + 1;
                    }
                }

                if (currentItem.name.equals(BACKSTAGE_PASSES)) {
                    currentItem.quality = 0;
                }

                if (isRegularItem(currentItem)) {
                    if (currentItem.quality > 0) {
                        currentItem.quality = currentItem.quality - 1;
                    }
                }
            }
        }
    }

    private void reduceSellInExceptSulfuras(Item currentItem) {
        if (!currentItem.name.equals(SULFURAS)) {
            currentItem.sellIn = currentItem.sellIn - 1;
        }
    }

    private void decreaseBackstagePassQuality(Item currentItem) {
        if (currentItem.sellIn < 11) {
            if (currentItem.quality < 50) {
                currentItem.quality = currentItem.quality + 1;
            }
        }

        if (currentItem.sellIn < 6) {
            if (currentItem.quality < 50) {
                currentItem.quality = currentItem.quality + 1;
            }
        }
    }

    private boolean isRegularItem(Item currentItem) {
        return !currentItem.name.equals(AGED_BRIE)
                && !currentItem.name.equals(BACKSTAGE_PASSES)
                && !currentItem.name.equals(SULFURAS);
    }
}
