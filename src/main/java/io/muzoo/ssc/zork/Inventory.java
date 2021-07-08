package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

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

    public Item getItem(String item) {
        for(int i=0; i<items.size(); i++) {
            if(items.get(i).getItemName().equals(item)) {
                return items.get(i);
            }
        }
        return null;
    }
}
