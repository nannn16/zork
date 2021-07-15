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
    public String getDescription() {
        return "– end the current game and return to command prompt to let user choose the map or load from saved point again";
    }

    @Override
    public boolean execute(Game game, List<String> args, boolean isPlay) {
        if(isPlay) {
            game.quit();
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
