package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Room {

    private String description;
    private List<Item> items;
    private Monster monster;
    private HashMap<String, Room> exits;

    public Room(String description, List<Item> items) {
        this.description = description;
        this.items = items;
        this.monster = new Monster();
        this.exits = new HashMap<>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    public void setExits(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public boolean canMove(String direction) {
        return exits.containsKey(direction);
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, Room> getExits() {
        return exits;
    }

    public Monster getMonster() {
        return monster;
    }

    public int getItemIndex(String item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemName().equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public Item getItem(String item) {
        int i = getItemIndex(item);
        if(i >= 0) {
            return items.get(i);
        }
        return null;
    }

    public void removeItem(String item) {
        int i = getItemIndex(item);
        if(i >= 0) {
            items.remove(i);
        }
    }

    public List<String> getItemsStat() {
        List<String> itemsStat = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            String stat = items.get(i).getItemStat();
            itemsStat.add(stat);
        }
        return itemsStat;
    }

    public String getExitInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Doors: ");
        Set<String> directions = exits.keySet();
        for (String direction : directions) {
            info.append(direction + " ");
        }
        info.append("\n");
        return info.toString();
    }

    public String getStat() {
        StringBuilder info = new StringBuilder();
        // monster not die yet
        if(monster.getHP() > 0) {
            info.append(monster.getStat());
        }
        List<String> itemsStat = getItemsStat();
        for(int i=0; i<itemsStat.size(); i++) {
            info.append(itemsStat.get(i));
            info.append("\n");
        }
        info.append(getExitInfo());
        return info.toString();
    }
}
