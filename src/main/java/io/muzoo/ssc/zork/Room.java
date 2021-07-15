package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Room {

    private String description;
    private Inventory inventory;
    private Monster monster;
    private HashMap<String, Room> exits;

    public Room(String description, List<Item> items) {
        this.description = description;
        this.inventory = new Inventory();
        inventory.addAllItems(items);
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

    public boolean isMonsterAlive() {
        return monster.isAlive();
    }

    public Monster getMonster() {
        return monster;
    }

    public Item getItem(String item) {
        return inventory.getItem(item);
    }

    public void removeItem(Item item) {
        inventory.dropItem(item);
    }

    public List<String> getItemsStat() {
        return inventory.getItemsStat();
    }

    public String getExitInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Doors: ");
        Set<String> directions = exits.keySet();
        for (String direction : directions) {
            info.append(direction + " ");
        }
        return info.toString();
    }

    public String getStat() {
        StringBuilder info = new StringBuilder();
        info.append(description);
        info.append("\n");
        // monster not die yet
        if(monster.isAlive()) {
            info.append(monster.getStat());
            info.append("\n");
        }
        List<String> itemsStat = getItemsStat();
        for (String s : itemsStat) {
            info.append(s);
            info.append("\n");
        }
        info.append(getExitInfo());
        return info.toString();
    }
}
