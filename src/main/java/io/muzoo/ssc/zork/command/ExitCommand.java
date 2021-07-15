package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

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
    public boolean execute(Game game, List<String> args, boolean isPlay) {
        if(!isPlay) {
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
