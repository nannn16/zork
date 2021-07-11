package io.muzoo.ssc.zork;

import java.util.Random;

public class Monster {

    private int HP;
    private int MaxHP;
    private int attackPower;
    private final int MAXHP_UPPPERBOUND = 1000;
    private final int MAXHP_LOWERBOUND = 100;
    private final int ATTACKPOWER_UPPERBOUND = 200;
    private final int ATTACKPOWER_LOWERBOUND = 50;
    private Random random = new Random();

    public Monster() {
        this.MaxHP = random.nextInt(MAXHP_UPPPERBOUND-MAXHP_LOWERBOUND) + MAXHP_LOWERBOUND;
        this.HP = MaxHP;
        this.attackPower = random.nextInt(ATTACKPOWER_UPPERBOUND-ATTACKPOWER_LOWERBOUND) + ATTACKPOWER_LOWERBOUND;
    }

    public int getHP() {
        return HP;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void beingAttacked(int attackPower) {
        HP -= random.nextInt(attackPower);
    }

    public String getStat() {
        return "monster HP: " + HP + "/" + MaxHP + " attack power: " + attackPower;
    }
}
