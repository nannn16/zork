package io.muzoo.ssc.zork;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final int MAX_ITEMS = 10;
    private int numItems;
    private List<Item> items;

    public Inventory() {
        numItems = 0;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        numItems++;
        items.add(item);
    }

    public void dropItem(Item item) {
        numItems--;
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
