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

    public void addAllItems(List<Item> itemList) {
        items.addAll(itemList);
    }

    public void dropItem(Item item) {
        items.remove(item);
    }

    public Item getItem(String item) {
        for (Item value : items) {
            if (value.getItemName().equals(item)) {
                return value;
            }
        }
        return null;
    }

    public List<String> getItemsStat() {
        List<String> itemsStat = new ArrayList<>();
        for (Item item : items) {
            String stat = item.getItemStat();
            itemsStat.add(stat);
        }
        return itemsStat;
    }

    public String listItems() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.getItemName());
            sb.append(" ");
        }
        return sb.toString();
    }

    public List<Item> cloneList() {
        List<Item> clonedList = new ArrayList<>(items);
        return clonedList;
    }
}
