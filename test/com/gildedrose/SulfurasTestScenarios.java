package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasTestScenarios {

    @Test
    public void Sulfuras_always_have_quality_80() {

        // ARRANGE - set items and pass to app
        Item[] items = {
                new Item("Sulfuras, Hand of Ragnaros", 5, 80), //
                new Item("Sulfuras, Hand of Ragnaros", 20, 80)
        };

        GildedRose app = new GildedRose(items);

        // ACT - 1 day
        app.updateQuality();

        // ASSERT
        assertEquals(80, items[0].quality);
        assertEquals(80, items[1].quality);
    }

    @Test
    public void Sulfuras_with_zero_days_always_have_quality_80_and_sellIn_stays_zero() {

        // ARRANGE - set items and pass to app
        Item[] items = {
                new Item("Sulfuras, Hand of Ragnaros", 0, 80)
        };

        GildedRose app = new GildedRose(items);

        // ACT - 1 day
        app.updateQuality();

        // ASSERT
        assertEquals(80, items[0].quality);
        assertEquals(0, items[0].sellIn);
    }

    @Test
    public void Sulfuras_with_negative_days_always_have_quality_80_and_sellIn_does_not_change() {

        // ARRANGE - set items and pass to app
        Item[] items = {
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Sulfuras, Hand of Ragnaros", -7, 80)

        };

        GildedRose app = new GildedRose(items);

        // ACT - 1 day
        app.updateQuality();

        // ASSERT
        assertEquals(80, items[0].quality);
        assertEquals(-1, items[0].sellIn);

        assertEquals(80, items[1].quality);
        assertEquals(-7, items[1].sellIn);
    }
}
