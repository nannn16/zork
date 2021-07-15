package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.map.ZorkMap;

public class GameOutput {

    public void println(String message) {
        System.out.println(message);
    }

    public void startGame() {
        System.out.println("Welcome to Zork");
        StringBuilder sb = new StringBuilder();
        for(String mapName: MapFactory.getAllMapName()) {
            sb.append(mapName);
            sb.append(" ");
        }
        System.out.println("Available Map: " + sb);
    }

    public void help(boolean isPlay) {
        System.out.println("Available command:");
        if (isPlay) {
            for (Command cmd : CommandFactory.getPlayCommand()) {
                System.out.println(cmd.getCommand() + " " + cmd.getDescription());
            }
        } else {
            for (Command cmd : CommandFactory.getStartCommand()) {
                System.out.println(cmd.getCommand() + " " + cmd.getDescription());
            }
        }
    }

    public void info(Player player, ZorkMap map) {
        System.out.println("Player: ");
        System.out.println(player.getStat());
        System.out.println("------------------------------");
        System.out.println("Room: ");
        System.out.println(map.getCurrentRoom().getStat());
    }
}
