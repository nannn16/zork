package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.List;

public class ExitCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "– exit whole game";
    }

    @Override
    public boolean execute(Game game, List<String> args) {
        boolean isPlay = game.isPlay();
        if(!isPlay) {
            game.getOutput().println("Game exit");
            game.exit();
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
