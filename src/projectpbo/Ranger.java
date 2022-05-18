/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

import java.io.Serializable;

/**
 *
 * @author RyanK
 */
public abstract class Ranger implements Serializable{
    private String nama;
    private int level;
    private int hp;
    private int dmg;
    private int range;
    private int movement;
    private int mineral;

    public Ranger(String nama, int hp, int dmg, int range, int movement, int mineral) {
        this.nama = nama;
        this.level = 1;
        this.hp = hp;
        this.dmg = dmg;
        this.range = range;
        this.movement = movement;
        this.mineral = mineral;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getMineral() {
        return mineral;
    }

    public void setMineral(int mineral) {
        this.mineral = mineral;
    }
}
