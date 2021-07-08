package io.muzoo.ssc.zork.item;

public class Defense extends Item {

    private int defensePower;

    public Defense(String itemName, int defensePower) {
        super(itemName);
        this.defensePower = defensePower;
    }

    @Override
    public String getItemStat() {
        String stat = getItemName() + " defense power: " + defensePower;
        return stat;
    }

    @Override
    public int getAttackPower() {
        return 0;
    }

    @Override
    public int getDefensePower() {
        return 0;
    }
}
