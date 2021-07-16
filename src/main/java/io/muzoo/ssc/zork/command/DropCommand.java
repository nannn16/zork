package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.List;

public class DropCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "drop";
    }

    @Override
    public String getDescription() {
        return "– drop item of choice that the player currently carries";
    }

    @Override
    public boolean execute(Game game, List<String> args) {
        boolean isPlay = game.isPlay();
        if(isPlay) {
            Player player = game.getPlayer();
            String object = args.get(0);
            boolean isDrop = player.drop(object);
            if (isDrop) {
                game.getOutput().println("Drop " + object);
            } else {
                game.getOutput().println("No such item in inventory");
            }
            return true;
        }
        else {
            game.getOutput().println("This command only available while playing game");
            return false;
        }
    }

    public boolean isPlay() {
        return true;
    }
}
