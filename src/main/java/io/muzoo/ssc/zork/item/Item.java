package io.muzoo.ssc.zork.item;

public abstract class Item {

    private String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public abstract String getItemStat();

    public abstract int getAttackPower();

    public abstract int getDefensePower();

}
