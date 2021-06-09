package io.muzoo.ssc.zork;

import java.util.Arrays;
import java.util.List;

public class CommandParser {

    public List<String> parse(String stringInput) {
        String[] strings = stringInput.trim().split(" ");
        return Arrays.asList(strings);
    }
}
