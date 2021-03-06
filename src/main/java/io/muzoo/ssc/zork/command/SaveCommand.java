package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.Save;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.List;

public class SaveCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "- save game state";
    }

    @Override
    public boolean execute(Game game, List<String> args) {
        boolean isPlay = game.isPlay();
        if(isPlay) {
            game.savePoint(args.get(0));
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
