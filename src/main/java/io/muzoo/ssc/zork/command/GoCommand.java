package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

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
    public boolean execute(Game game, List<String> args, boolean isPlay) {
        if(isPlay) {
            game.go(args.get(0));
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
