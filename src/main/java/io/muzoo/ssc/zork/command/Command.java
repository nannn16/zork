package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.List;

public interface Command {

    int numArgs();

    String getCommand();

    String getDescription();

    boolean execute(Game game, List<String> args);

    boolean isPlay();
}
