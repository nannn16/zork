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
            boolean canExecute = command.execute(this, words.subList(1, words.size()), isPlay);
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

    public void exit() {
        output.println("Game exit");
        System.exit(0);
    }

    public void help() {
        output.help(isPlay);
    }

    public void info() {
        output.info(player, map);
    }

    public void go(String direction) {
        if (direction.equals("")) {
            output.println("Go where?");
            return;
        }

        boolean move = map.moveRoom(direction);
        if (!move) {
            output.println("There is no room");
        } else {
            player.increaseHP();
            output.println(map.getCurrentRoom().getDescription());
        }
    }

    public void take(String object) {
        Room currentRoom = map.getCurrentRoom();
        Item item = currentRoom.getItem(object);
        if (item != null) {
            player.take(item);
            currentRoom.removeItem(item);
            output.println("Pick up " + object);
        } else {
            output.println("No such item in this room");
        }
    }

    public void drop(String object) {
        boolean isDrop = player.drop(object);
        if (isDrop) {
            output.println("Drop " + object);
        } else {
            output.println("No such item in inventory");
        }
    }

    public void attackWith(String weapon) {
        Room room = map.getCurrentRoom();
        Monster monster = room.getMonster();
        if (monster == null || monster.getHP() <= 0) {
            output.println("Monster already died");
        } else {
            boolean isAttack = player.attack(monster, weapon);
            if (!isAttack) {
                output.println("No such weapon in the inventory");
            } else if (player.getHP() <= 0) {
                gameOver();
            } else {
                defeatMonster();
            }
        }
    }

    public void defeatMonster() {
        output.println("Defeat a monster");
        if (map.isEnd()) {
            end();
        }
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
