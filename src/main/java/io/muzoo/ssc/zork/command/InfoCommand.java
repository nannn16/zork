package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.List;

public class InfoCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "– print out information of the player and the room that the player is currently in";
    }

    @Override
    public boolean execute(Game game, List<String> args) {
        boolean isPlay = game.isPlay();
        if(isPlay) {
            Player player = game.getPlayer();
            ZorkMap map = game.getMap();
            game.getOutput().info(player, map);
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
