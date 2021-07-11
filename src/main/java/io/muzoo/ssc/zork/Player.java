package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;

import java.util.Random;

public class Player {

    private final int MAX_HP = 1000;
    private final int INCREASE_HP = 100;
    private final int DEFAULT_ATTACKPOWER = 100;
    private int HP;
    private int attackPower;
    private Inventory inventory;
    private Random random = new Random();

    public Player() {
        this.HP = MAX_HP;
        this.attackPower = DEFAULT_ATTACKPOWER;
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

    public Inventory getInventory() {
        return inventory;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void beingAttacked(int attackPower) {
        HP -= random.nextInt(attackPower);
    }

    public void attack(Monster monster, Item weapon) {
        int power = attackPower + weapon.getAttackPower();
        while(monster.getHP() > 0 && HP > 0) {
            monster.beingAttacked(power);
            beingAttacked(monster.getAttackPower());
        }
    }
}
