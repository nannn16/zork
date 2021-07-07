package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

import java.util.List;

public class TakeCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "take";
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.take(args.get(0));
    }

    @Override
    public boolean isPlay() {
        return true;
    }
}
