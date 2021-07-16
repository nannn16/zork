package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.List;

public class GoCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "go";
    }

    @Override
    public String getDescription() {
        return "– move player to the room as specified by the direction (north, east, west, south)";
    }

    @Override
    public boolean execute(Game game, List<String> args) {
        boolean isPlay = game.isPlay();
        if(isPlay) {
            Player player = game.getPlayer();
            ZorkMap map = game.getMap();
            String direction = args.get(0);
            if (direction.equals("")) {
                game.getOutput().println("Go where?");
                return true;
            }

            boolean move = map.moveRoom(direction);
            if (!move) {
                game.getOutput().println("There is no room");
            } else {
                player.increaseHP();
                game.getOutput().println(map.getCurrentRoom().getDescription());
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isPlay() {
        return true;
    }
}
