package io.muzoo.ssc.zork;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final int MAX_ITEMS = 10;
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void dropItem(Item item) {
        items.remove(item);
    }
}
