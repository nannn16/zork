package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;

import java.util.Random;

public class Player extends Stat {

    private final int MAX_HP = 1000;
    private final int INCREASE_HP = 100;
    private int HP;
    private int attackPower;
    private Inventory inventory;
    private Random random = new Random();

    public Player() {
        this.HP = MAX_HP;
        this.attackPower = 100;
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

    public void increaseAttackPower(int attackPower) {
        this.attackPower += attackPower;
    }

    public void attack(Monster monster, Item weapon) {
        int power = attackPower + weapon.getAttackPower();
        while(monster.getHP() > 0 && HP > 0) {
            int monsterHP = monster.getHP() - random.nextInt(power);
            monster.setHP(monsterHP);
            HP -= random.nextInt(monster.getAttackPower());
        }
    }
}
