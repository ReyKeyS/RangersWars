/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

/**
 *
 * @author RyanK
 */
public class Enemy {
    private int level;
    private int hp;
    private int dmg;

    public Enemy(int level) {
        this.level = level;
        this.hp = 280 + level*20;
        this.dmg = 25 + level*15;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
    
    
}
