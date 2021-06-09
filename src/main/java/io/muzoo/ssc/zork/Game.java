package io.muzoo.ssc.zork;

import java.util.List;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();

    private CommandParser commandParser = new CommandParser();

    public void run() {
        while(true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            List<String> words = commandParser.parse(s);
            output.println(s);
        }
    }

    public void exit() {
        output.println("Game exit");
        System.exit(0);
    }
}
