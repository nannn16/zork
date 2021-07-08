package io.muzoo.ssc.zork.item;

public class Weapon extends Item {

    private int attackPower;

    public Weapon(String itemName, int attackPower) {
        super(itemName);
        this.attackPower = attackPower;
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public int getDefensePower() {
        return 0;
    }

    @Override
    public String getItemStat() {
        String stat = getItemName() + ": attack power:" + attackPower;
        return stat;
    }
}
