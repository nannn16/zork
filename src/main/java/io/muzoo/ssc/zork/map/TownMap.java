package io.muzoo.ssc.zork.map;

import io.muzoo.ssc.zork.item.Defense;
import io.muzoo.ssc.zork.item.Item;
import io.muzoo.ssc.zork.Room;
import io.muzoo.ssc.zork.item.Weapon;

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
        List<Item> outsideItems = new ArrayList<>();
        outsideItems.add(new Weapon("pan", 50));
        outsideItems.add(new Weapon("crossbow", 70));
        List<Item> pubItems = new ArrayList<>();
        pubItems.add(new Weapon("knife", 100));
        pubItems.add(new Defense("helmet", 20));
        List<Item> gymItems = new ArrayList<>();
        gymItems.add(new Weapon("sword", 200));
        List<Item> playgroundItems = new ArrayList<>();
        playgroundItems.add(new Defense("vest", 30));

        // create the rooms
        Room outside = new Room("outside the main entrance of the town", outsideItems);
        Room pub = new Room("in the pub", pubItems);
        Room gym = new Room("in the gym", gymItems);
        Room playground = new Room("in the playground", playgroundItems);

        rooms = new ArrayList<>(Arrays.asList(outside, pub, gym, playground));

        // initialise room exits
        outside.setExits("west", pub);
        outside.setExits("north", playground);

        pub.setExits("east", outside);
        pub.setExits("north", gym);

        gym.setExits("south", pub);
        gym.setExits("east", playground);

        playground.setExits("south", outside);
        playground.setExits("west", gym);

        currentRoom = outside;  // start game outside
    }
}
