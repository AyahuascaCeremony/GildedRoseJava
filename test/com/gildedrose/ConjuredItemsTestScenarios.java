package com.gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredItemsTestScenarios {

    @Test
    public void ConjuredItems_quality_decreases_by_two_each_day() {
        Item[] items = {
                new Item("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, items[0].quality);
        assertEquals(2, items[0].sellIn);
    }

    @Test
    public void ConjuredItems_quality_cannot_be_negative() {
        Item[] items = {
                new Item("Conjured Mana Cake", 3, 0),
                new Item("Conjured Mana Cake", 5, 2),
                new Item("Conjured Mana Cake", 5, 1)

        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
        assertEquals(2, items[0].sellIn);

        assertEquals(0, items[1].quality);
        assertEquals(4, items[1].sellIn);

        assertEquals(0, items[2].quality);
        assertEquals(4, items[2].sellIn);
    }

}
