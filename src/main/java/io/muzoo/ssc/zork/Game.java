package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.item.Item;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();
    private Save save = new Save();
    private ZorkMap map;
    private Player player;
    private boolean isPlay;
    private List<String> inputCommands = new ArrayList<>();

    public void run() {
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            inputCommands.add(s);
            executeCommand(s);
        }
    }

    public void executeCommand(String s) {
        List<String> words = commandParser.parse(s);
        Command command = CommandFactory.get(words.get(0));
        if(command != null && command.getCommand().equals("help")) {
            command.execute(this, words.subList(1, words.size()));
        }
        else if (command != null && command.isPlay()) {
            if(isPlay) {
                command.execute(this, words.subList(1, words.size()));
            }
            else {
                output.println("this command only available while playing game");
            }
        }
        else if (command != null && !command.isPlay()) {
            if(!isPlay) {
                command.execute(this, words.subList(1, words.size()));
            }
            else {
                output.println("this command only available when start the game");
            }
        }
        else {
            output.println("command not found");
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void reset() {
        player = new Player();
        map = null;
        inputCommands.clear();
    }

    public void play(String mapName) {
        isPlay = true;
        reset();
        map = MapFactory.get(mapName);
        if (map != null) {
            map.initialize();
            output.println(map.getCurrentRoom().getDescription());
        } else {
            output.println(mapName + " map doesn't exist");
        }
    }

    public void quit() {
        isPlay = false;
        reset();
        output.println("Game quit");
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
        output.println("Attack Power: " + player.getAttackPower());
        output.println(map.getCurrentRoom().getStat());
    }

    public void go(String direction) {
        boolean move = map.moveRoom(direction);
        if(move) {
            output.println("there is no room");
        }
        else {
            player.increaseHP();
            output.println(map.getCurrentRoom().getDescription());
        }
    }

    public void take(String object) {
        Item item = map.getCurrentRoom().getItem(object);
        if(item != null) {
            player.getInventory().addItem(item);
            map.getCurrentRoom().removeItem(object);
            output.println("pick up " + object);
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

    public void attackWith(String weapon) {
        Item item = player.getInventory().getItem(weapon);
        Monster monster = map.getCurrentRoom().getMonster();
        if(item == null) {
            output.println("no such item");
        }
        else if(monster == null || monster.getHP() <= 0) {
            output.println("monster already died");
        }
        else {
            player.attack(monster, item);
            if(player.getHP() > 0) {
                output.println("player died");
                quit();
            }
            else {
                output.println("monster died");
            }
        }
    }

    public void savePoint(String savedPointName) {
        save.savePoint(savedPointName, inputCommands);
    }

    public void loadPoint(String savedPointName) {
        List<String> cmd = save.loadPoint(savedPointName);
        if(cmd == null) {
            output.println("there is no this saved point name");
        }
        else {
            for (String s : cmd) {
                executeCommand(s);
            }
        }
    }
}
