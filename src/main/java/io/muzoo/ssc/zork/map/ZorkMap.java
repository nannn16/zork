package io.muzoo.ssc.zork.map;

import io.muzoo.ssc.zork.Room;

public abstract class ZorkMap {

    private int width;
    private int depth;
    private Room[][] map;
    private Room currentRoom;

    public void initialize() {
        this.width = getWidth();
        this.depth = getDepth();
        this.map = new Room[width][depth];
        this.currentRoom = map[0][0];
    }

    public void moveRoom(String direction) {

    }

    public abstract String getMapName();

    protected abstract int getWidth();

    protected abstract int getDepth();

}
