package io.muzoo.ssc.zork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Room {

    private String description;
    private List<Item> items;
    private List<Monster> monsters;
    private HashMap<String, Room> exits;

    public Room(String description, List<Item> items) {
        this.description = description;
        this.items = items;
        this.monsters = new ArrayList<>();
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

    public String getDescription()
    {
        return description;
    }

    public HashMap<String, Room> getExits() {
        return exits;
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
