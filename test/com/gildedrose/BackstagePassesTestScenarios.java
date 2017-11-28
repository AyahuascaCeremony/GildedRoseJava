package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassesTestScenarios {

    @Test
    public void BackstagePasses_increase_in_quality() {
        Item[] items = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(21, items[0].quality);
        assertEquals(14, items[0].sellIn);
    }

    @Test
    public void BackstagePasses_with_ten_or_less_days_increase_in_quality_at_double_rate() {
        Item[] items = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 35),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 35),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 35)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(37, items[0].quality);
        assertEquals(9, items[0].sellIn);

        assertEquals(37, items[1].quality);
        assertEquals(8, items[1].sellIn);

        assertEquals(37, items[2].quality);
        assertEquals(5, items[2].sellIn);
    }

    @Test
    public void BackstagePasses_with_five_or_less_days_increase_in_quality_at_triple_rate() {
        Item[] items = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 35),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 35),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 35)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(38, items[0].quality);
        assertEquals(4, items[0].sellIn);

        assertEquals(38, items[1].quality);
        assertEquals(3, items[1].sellIn);

        assertEquals(38, items[2].quality);
        assertEquals(0, items[2].sellIn);
    }

    @Test
    public void BackstagePasses_with_zero_or_less_days_have_zero_quality() {
        Item[] items = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 35),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 50)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
        assertEquals(-1, items[0].sellIn);

        assertEquals(0, items[1].quality);
        assertEquals(-2, items[1].sellIn);
    }
}
