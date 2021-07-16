package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.List;

public class LoadCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "load";
    }

    @Override
    public String getDescription() {
        return "– load game state from saved point";
    }

    @Override
    public boolean execute(Game game, List<String> args) {
        boolean isPlay = game.isPlay();
        if(!isPlay) {
            game.loadPoint(args.get(0));
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isPlay() {
        return false;
    }
}
