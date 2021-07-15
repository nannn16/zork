package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

import java.util.List;

public class PlayCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "play";
    }

    @Override
    public String getDescription() {
        return "– play new game";
    }

    @Override
    public boolean execute(Game game, List<String> args, boolean isPlay) {
        if(!isPlay) {
            game.play(args.get(0));
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
