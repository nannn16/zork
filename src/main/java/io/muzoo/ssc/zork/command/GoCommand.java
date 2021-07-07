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
    public void execute(Game game, List<String> args) {
        game.go(args.get(0));
    }

    @Override
    public boolean isPlay() {
        return true;
    }
}
