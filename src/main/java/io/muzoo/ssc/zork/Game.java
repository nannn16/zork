package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.item.Item;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.List;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();
    private SavePoint savePoints = new SavePoint();
    private ZorkMap map;
    private Player player;
    private boolean isPlay;

    public void run() {
        output.startGame();
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            executeCommand(s);
        }
    }

    public void executeCommand(String s) {
        List<String> words = commandParser.parse(s);
        Command command = CommandFactory.get(words.get(0));
        if (command != null) {
            boolean canExecute = command.execute(this, words.subList(1, words.size()));
            if (!canExecute) {
                if (!isPlay) {
                    output.println("This command only available while playing game");
                } else {
                    output.println("This command only available at when start the game");
                }
            }
        } else {
            output.println("Command not found");
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public ZorkMap getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isPlay() {
        return isPlay;
    }

    public void exit() {
        System.exit(0);
    }

    public void reset() {
        player = new Player();
        map = null;
    }

    public void play(String mapName) {
        reset();
        map = MapFactory.get(mapName);
        if (map != null) {
            isPlay = true;
            map.initialize();
            output.println(map.getCurrentRoom().getDescription());
        } else {
            output.println(mapName + " Map doesn't exist");

        }
    }

    public void quit() {
        isPlay = false;
        reset();
        output.println("Game quit");
    }

    public void gameOver() {
        output.println("Player died");
        output.println("Game over");
        quit();
    }

    // if the game end
    public void end() {
        output.println("Game End!!!");
        quit();
    }

    public void savePoint(String savedPointName) {
        Save save = new Save(map, player);
        savePoints.savePoint(savedPointName, save);
        output.println("Saved");
    }

    public void loadPoint(String savedPointName) {
        Save save = savePoints.loadPoint(savedPointName);
        if (save == null) {
            output.println("There is no this saved point name");
        } else {
            isPlay = true;
            map = save.getMap();
            player = save.getPlayer();
            output.println("Finish loading");
        }
    }
}
