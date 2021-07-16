package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Monster;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.Room;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.util.List;

public class AttackWithCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "attack with";
    }

    @Override
    public String getDescription() {
        return "- is used to attack a monster in the current room";
    }

    @Override
    public boolean execute(Game game, List<String> args) {
        boolean isPlay = game.isPlay();
        if(isPlay) {
            Player player = game.getPlayer();
            ZorkMap map = game.getMap();
            String weapon = args.get(0);
            Room room = game.getMap().getCurrentRoom();
            Monster monster = room.getMonster();
            if (monster == null || monster.getHP() <= 0) {
                game.getOutput().println("Monster already died");
            } else {
                boolean isAttack = player.attack(monster, weapon);
                if (!isAttack) {
                    game.getOutput().println("No such weapon in the inventory");
                } else if (player.getHP() <= 0) {
                    game.gameOver();
                } else {
                    game.getOutput().println("Defeat a monster");
                    if (map.isEnd()) {
                        game.end();
                    }
                }
            }
            return true;
        }
        else {
            game.getOutput().println("This command only available while playing game");
            return false;
        }
    }

    @Override
    public boolean isPlay() {
        return true;
    }
}
