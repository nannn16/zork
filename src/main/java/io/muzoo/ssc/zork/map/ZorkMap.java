package io.muzoo.ssc.zork.map;

import io.muzoo.ssc.zork.GameOutput;
import io.muzoo.ssc.zork.Room;

import java.util.ArrayList;

public abstract class ZorkMap {

    private GameOutput output = new GameOutput();

    protected Room currentRoom;
    protected ArrayList<Room> rooms;

    public void initialize() {
        createRooms();
    }

    public boolean moveRoom(String direction) {
        boolean canmove = currentRoom.canMove(direction);
        if(canmove) {
            Room nextRoom = currentRoom.getExits().get(direction);
            currentRoom = nextRoom;
        }
        return canmove;
    }

    public abstract String getMapName();

    protected abstract void createRooms();

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
