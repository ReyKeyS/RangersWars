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
        this.hp = 250 + level*50;
        this.dmg = 10 + level*30;
        if (level % 10 == 0){
            this.dmg = (10 + level*30) + (10 + level*30)/4;
        }
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
