package io.muzoo.ssc.zork;

public class Player extends Stat {

    private final int MAX_HP = 1000;
    private int HP;
    private int attackPower;
    private Inventory inventory;

    public Player() {
        this.HP = MAX_HP;
        this.attackPower = 1000;
        this.inventory = new Inventory();
    }

    @Override
    protected int getHP() {
        return HP;
    }

    @Override
    protected int getMaxHP() {
        return MAX_HP;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
