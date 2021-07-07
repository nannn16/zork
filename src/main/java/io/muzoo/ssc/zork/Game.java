package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.List;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();
    private ZorkMap map;
    private Player player;
    private boolean isPlay;

    public void run() {
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            List<String> words = commandParser.parse(s);
            Command command = CommandFactory.get(words.get(0));
            if (command != null && command.isPlay()) {
                if(isPlay) {
                    command.execute(this, words.subList(1, words.size()));
                }
                else {
                    output.println("this command only available while playing game");
                }
            }
            else if (command != null && !command.isPlay()) {
                command.execute(this, words.subList(1, words.size()));
            }
            else {
                output.println("command not found");
            }
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void play(String mapName) {
        isPlay = true;
        map = MapFactory.get(mapName);
        player = new Player();
        if (map != null) {
            map.initialize();
            output.println(map.getCurrentRoom().getDescription());
        } else {
            output.println(mapName + " map doesn't exist");
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void help() {
        for (String cmd : CommandFactory.getAllCommand()) {
            output.println(cmd);
        }
    }

    public void info() {
        output.println("HP: " + player.getHP() + "/" + player.getMaxHP());
    }

    public void go(String direction) {
        if(!map.canMove(direction)) {
            output.println("there is no room");
        }
        else {
            map.moveRoom(direction);
            output.println(map.getCurrentRoom().getDescription());
        }
    }

    public void take(String object) {
        Item item = map.getCurrentRoom().getItem(object);
        if(item != null) {
            player.getInventory().addItem(item);
            output.println("add " + object);
        }
        else {
            output.println("no such item.");
        }
    }

    public void drop(String object) {
        Item item = player.getInventory().getItem(object);
        if(item != null) {
            player.getInventory().dropItem(item);
            output.println("drop " + object);
        }
        else {
            output.println("no such item.");
        }
    }
}
