package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

import java.util.List;

public class QuitCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "quit";
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.quit();
    }

    @Override
    public boolean isPlay() {
        return true;
    }
}
