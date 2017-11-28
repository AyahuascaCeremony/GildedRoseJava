package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTestScenarios {

    @Test
    public void AgedBrie_quality_increases_each_day() {
        Item[] items = {
                new Item("Aged Brie", 2, 0)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, items[0].quality);
        assertEquals(1, items[0].sellIn);
    }

    @Test
    public void AgedBrie_quality_cannot_exceed_fifty() {
        Item[] items = {
                new Item("Aged Brie", 2, 50)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, items[0].quality);
        assertEquals(1, items[0].sellIn);
    }
}
