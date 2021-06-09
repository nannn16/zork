package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.command.ExitCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandFactory {

    private static final List<Class<? extends Command>> REGISTERED_COMMANDS = Arrays.asList(ExitCommand.class);

    private static final List<Command> COMMANDS = new ArrayList<>();
}
