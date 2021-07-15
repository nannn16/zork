package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;
import io.muzoo.ssc.zork.item.Weapon;

import java.util.List;
import java.util.Random;

public class Player {

    private final int MAX_HP = 1000;
    private final int INCREASE_HP = 100;
    private final int INCREASE_ATTACK_POWER = 20;
    private final int DEFAULT_ATTACKPOWER = 100;

    private int HP;
    private int attackPower;
    private int defensePower;
    private Inventory inventory;
    private Random random = new Random();

    public Player() {
        this.HP = MAX_HP;
        this.attackPower = DEFAULT_ATTACKPOWER;
        this.defensePower = 0;
        this.inventory = new Inventory();
    }

    protected int getHP() {
        return HP;
    }

    protected int getMaxHP() {
        return MAX_HP;
    }

    public void increaseHP() {
        HP += INCREASE_HP;
        if(HP > MAX_HP) {
            HP = MAX_HP;
        }
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void increaseAttackPower() {
        attackPower += INCREASE_ATTACK_POWER;
    }

    public void setDeepCopyInventory() {
        List<Item> items = inventory.cloneList();
        inventory = new Inventory();
        inventory.addAllItems(items);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void beingAttacked(int attackPower) {
        if(attackPower < 0) {
            attackPower = 0;
        }
        HP -= random.nextInt(attackPower);
        if(HP < 0) {
            HP = 0;
        }
    }

    // return true if there is an item in player's inventory or empty string, else return false
    public boolean attack(Monster monster, String weapon) {
        Item item = inventory.getItem(weapon);
        int power = attackPower;
        if(!weapon.equals("") && !(item instanceof Weapon)) {
            return false;
        }

        if (item instanceof Weapon) {
            power = attackPower + item.getAttackPower();
        }
        while(monster.getHP() > 0 && HP > 0) {
            monster.beingAttacked(power);
            beingAttacked(monster.getAttackPower() - defensePower);
        }
        // Player attack power will increase if he/she can defeat a monster
        increaseAttackPower();
        return true;
    }

    public void take(Item item) {
        defensePower += item.getDefensePower();
        inventory.addItem(item);
    }

    public boolean drop(String item) {
        Item it = inventory.getItem(item);
        if(it != null) {
            inventory.dropItem(it);
            return true;
        }
        return false;
    }

    public String getStat() {
        StringBuilder sb = new StringBuilder();
        sb.append("HP: ").append(getHP()).append("/").append(getMaxHP());
        sb.append("\n");
        sb.append("Attack Power: ").append(attackPower);
        sb.append(" Defense Power: ").append(defensePower);
        sb.append("\n");
        sb.append("Inventory: ");
        sb.append(inventory.listItems());
        return sb.toString();
    }
}
