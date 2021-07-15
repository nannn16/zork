package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.map.ZorkMap;

public class Save {

    private ZorkMap map;
    private Player player;

    public Save(ZorkMap map, Player player) {
        Player player1 = new Player();
        player1.setHP(player.getHP());
        player1.setAttackPower(player.getAttackPower());
        player1.setDeepCopyInventory();

        this.map = map;
        this.player = player1;
    }

    public ZorkMap getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }
}
