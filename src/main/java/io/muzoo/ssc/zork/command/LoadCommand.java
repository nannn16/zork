package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

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
    public void execute(Game game, List<String> args) {
        game.loadPoint(args.get(0));
    }

    @Override
    public boolean isPlay() {
        return false;
    }
}
