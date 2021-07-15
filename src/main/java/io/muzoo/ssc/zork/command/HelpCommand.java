package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

import java.util.List;

public class HelpCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "– print all commands";
    }

    @Override
    public boolean execute(Game game, List<String> args, boolean isPlay) {
        game.help();
        return true;
    }

    @Override
    public boolean isPlay() {
        return false;
    }
}
