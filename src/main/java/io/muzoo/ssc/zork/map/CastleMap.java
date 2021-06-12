package io.muzoo.ssc.zork.map;

public class CastleMap extends ZorkMap {

    @Override
    public String getMapName() {
        return "castle";
    }

    @Override
    protected int getWidth() {
        return 5;
    }

    @Override
    protected int getDepth() {
        return 4;
    }
}
