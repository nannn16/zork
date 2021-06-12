package io.muzoo.ssc.zork.map;

public class TownMap extends ZorkMap {

    @Override
    public String getMapName() {
        return "town";
    }

    @Override
    protected int getWidth() {
        return 5;
    }

    @Override
    protected int getDepth() {
        return 5;
    }
}
