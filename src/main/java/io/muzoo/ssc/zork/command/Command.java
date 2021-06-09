package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

public interface Command {

    int numArgs();

    String getCommand();

    void execute(Game game);
}
