package io.muzoo.ssc.zork.map;

import io.muzoo.ssc.zork.Room;

import java.util.ArrayList;

public abstract class ZorkMap {

    protected Room currentRoom;
    protected ArrayList<Room> rooms;

    public void initialize() {
        createRooms();
    }

    public boolean moveRoom(String direction) {
        boolean canMove = currentRoom.canMove(direction);
        if(canMove) {
            Room nextRoom = currentRoom.getExits().get(direction);
            currentRoom = nextRoom;
        }
        return canMove;
    }

    public abstract String getMapName();

    protected abstract void createRooms();

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean isEnd() {
        for (Room room: rooms) {
            if(room.isMonsterAlive()) {
                return false;
            }
        }
        return true;
    }
}
