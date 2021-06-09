package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

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
    public void execute(Game game) {
        game.exit();
    }
}
