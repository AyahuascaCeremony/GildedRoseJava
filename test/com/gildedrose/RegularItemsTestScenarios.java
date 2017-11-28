package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularItemsTestScenarios {

    @Test
    public void RegularItems_quality_decreases_each_day() {
        Item[] items = {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Elixir of the Mongoose", 5, 7)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, items[0].quality);
        assertEquals(9, items[0].sellIn);

        assertEquals(6, items[1].quality);
        assertEquals(4, items[1].sellIn);
    }

    @Test
    public void RegularItems_quality_cannot_be_negative() {
        Item[] items = {
                new Item("+5 Dexterity Vest", 10, 0),
                new Item("Elixir of the Mongoose", 5, 0)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
        assertEquals(9, items[0].sellIn);

        assertEquals(0, items[1].quality);
        assertEquals(4, items[1].sellIn);
    }
}
