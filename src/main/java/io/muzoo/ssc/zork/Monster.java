package io.muzoo.ssc.zork;

import java.util.Random;

public class Monster {

    private int HP;
    private int MaxHP;
    private int attackPower;
    private Random random = new Random();

    public Monster() {
        this.MaxHP = random.nextInt(1000);
        this.HP = MaxHP;
        this.attackPower = random.nextInt(100);
    }

    public int getHP() {
        return HP;
    }

    public int getAttackPower() {
        return attackPower;
    }
}
