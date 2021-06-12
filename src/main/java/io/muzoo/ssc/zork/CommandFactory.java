package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandFactory {

    private static final List<Class<? extends Command>> REGISTERED_COMMANDS = Arrays.asList(ExitCommand.class,
            HelpCommand.class, InfoCommand.class, PlayCommand.class);

    private static final Map<String, Command> COMMAND_MAP = new HashMap<>();

    static {{
        for (Class<? extends Command> commandClass: REGISTERED_COMMANDS) {
            try {
                Command command = commandClass.getDeclaredConstructor().newInstance();
                COMMAND_MAP.put(command.getCommand(), command);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }}

    public static Command get(String command) {
        return COMMAND_MAP.get(command);
    }

    public static List<String> getAllCommand() {
        return new ArrayList<>(COMMAND_MAP.keySet());
    }
}
