package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.List;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();

    private CommandParser commandParser = new CommandParser();

    private ZorkMap map;

    public void run() {
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            List<String> words = commandParser.parse(s);
            Command command = CommandFactory.get(words.get(0));
            output.println(s);
            if (command != null) {
                command.execute(this, words.subList(1, words.size()));
            } else {
                output.println("command not found");
            }
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void play(String mapName) {
        map = MapFactory.get(mapName);
        if (map != null) {
            map.initialize();
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

    }
}
