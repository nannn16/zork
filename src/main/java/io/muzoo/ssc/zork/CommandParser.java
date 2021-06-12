package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.Command;

import java.util.*;

public class CommandParser {

    private List<String> allCommandsSortedByLength = new ArrayList<>();

    {
        allCommandsSortedByLength.addAll(CommandFactory.getAllCommand());
        allCommandsSortedByLength.sort((o1, o2) -> o1.length() - o2.length());
    }

    public String matchInputToCommand(String input) {
        for (String command : allCommandsSortedByLength) {
            if (input.startsWith(command)) {
                return command;
            }
        }
        return null;
    }

    public List<String> parse(String stringInput) {
        String cleanedInput = stringInput.trim();
        String cmd = matchInputToCommand(cleanedInput);
        Command command = CommandFactory.get(cmd);
        if (command != null && command.numArgs() > 0) {
            String argString = cleanedInput.substring(cmd.length()).trim();
            return Arrays.asList(cmd, argString);
        } else {
            return Arrays.asList(cmd);
        }
    }
}
