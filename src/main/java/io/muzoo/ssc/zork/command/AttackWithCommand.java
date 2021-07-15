package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

import java.util.List;

public class AttackWithCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "attack with";
    }

    @Override
    public String getDescription() {
        return "- is used to attack a monster in the current room";
    }

    @Override
    public boolean execute(Game game, List<String> args, boolean isPlay) {
        if(isPlay) {
            game.attackWith(args.get(0));
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
