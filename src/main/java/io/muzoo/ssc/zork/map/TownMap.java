package io.muzoo.ssc.zork.map;

import io.muzoo.ssc.zork.Item;
import io.muzoo.ssc.zork.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TownMap extends ZorkMap {

    @Override
    public String getMapName() {
        return "town";
    }

    @Override
    protected void createRooms()
    {
        List<Item> outsideItems = Arrays.asList(new Item("pan"));
        List<Item> pubItems = Arrays.asList(new Item("knife"));
        List<Item> gymItems = Arrays.asList(new Item("sword"));

        // create the rooms
        Room outside = new Room("outside the main entrance of the town", outsideItems);
        Room pub = new Room("in the pub", pubItems);
        Room gym = new Room("in the gym", gymItems);

        rooms = new ArrayList<Room>(Arrays.asList(outside, pub, gym));

        // initialise room exits
        outside.setExits("west", pub);

        pub.setExits("east", outside);
        pub.setExits("up", gym);

        gym.setExits("down", pub);

        currentRoom = outside;  // start game outside
    }
}
