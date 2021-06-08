package io.muzoo.ssc.zork;

import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();

    public void run() {
        while(true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            output.println(s);
        }
    }
}
