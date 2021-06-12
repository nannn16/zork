package io.muzoo.ssc.zork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Room {

    private List<Item> items;
    private List<Monster> monsters;
    public HashMap<String, Room> exits;

    public Room() {
        this.items = new ArrayList<>();
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
}
