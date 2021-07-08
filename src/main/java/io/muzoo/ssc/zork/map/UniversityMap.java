package io.muzoo.ssc.zork.map;

import io.muzoo.ssc.zork.item.Defense;
import io.muzoo.ssc.zork.item.Item;
import io.muzoo.ssc.zork.Room;
import io.muzoo.ssc.zork.item.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniversityMap extends ZorkMap {

    @Override
    public String getMapName() {
        return "university";
    }

    @Override
    protected void createRooms()
    {
        List<Item> outsideItems = new ArrayList<>();
        outsideItems.add(new Weapon("pan", 50));
        List<Item> theaterItems = new ArrayList<>();
        theaterItems.add(new Weapon("sword", 200));
        List<Item> labItems = new ArrayList<>();
        labItems.add(new Defense("helmet", 50));
        List<Item> officeItems = new ArrayList<>();
        officeItems.add(new Weapon("machine gun", 100));

        // create the rooms
        Room outside = new Room("outside the main entrance of the university", outsideItems);
        Room theater = new Room("in a lecture theater", theaterItems);
        Room lab = new Room("in a computing lab", labItems);
        Room office = new Room("in the computing admin office", officeItems);

        rooms = new ArrayList<Room>(Arrays.asList(outside, theater, lab, office));

        // initialise room exits
        outside.setExits("east", theater);
        outside.setExits("south", lab);

        theater.setExits("west", outside);

        lab.setExits("north", outside);
        lab.setExits("east", office);

        office.setExits("west", lab);

        currentRoom = outside;  // start game outside
    }
}
