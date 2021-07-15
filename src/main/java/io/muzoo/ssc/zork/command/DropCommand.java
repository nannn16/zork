package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

import java.util.List;

public class DropCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "drop";
    }

    @Override
    public String getDescription() {
        return "– drop item of choice that the player currently carries";
    }

    @Override
    public boolean execute(Game game, List<String> args, boolean isPlay) {
        if(isPlay) {
            game.drop(args.get(0));
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isPlay() {
        return true;
    }
}
