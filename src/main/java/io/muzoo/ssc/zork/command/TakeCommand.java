package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.Room;
import io.muzoo.ssc.zork.item.Item;
import io.muzoo.ssc.zork.map.ZorkMap;

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
    public String getDescription() {
        return "– take command is used to pick up the item in the current room";
    }

    @Override
    public boolean execute(Game game, List<String> args) {
        boolean isPlay = game.isPlay();
        if(isPlay) {
            Player player = game.getPlayer();
            ZorkMap map = game.getMap();
            String object = args.get(0);
            Room currentRoom = map.getCurrentRoom();
            Item item = currentRoom.getItem(object);
            if (item != null) {
                player.take(item);
                currentRoom.removeItem(item);
                game.getOutput().println("Pick up " + object);
            } else {
                game.getOutput().println("No such item in this room");
            }
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
