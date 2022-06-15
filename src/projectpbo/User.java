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
public class User implements Serializable{
    private String nama;
    private int level,gold;
    private Ranger[] ranger;
    private boolean[] choose = new boolean[5];
    private Tower tower;
    
    public User(String nama) {
        this.nama = nama;
        this.level = 1;
        this.gold = 0;
        this.ranger = new Ranger[5];
        ranger[0] = new Eris("Eris", 1);
        choose[0] = true;
        ranger[1] = new Yoimiya("Yoimiya", 1);
        choose[1] = true;
        ranger[2] = new RaidenShogun("RaidenShogun", 1);
        choose[2] = true;
        ranger[3] = new Tanjiro("Tanjiro", 1);
        choose[3] = false;
        ranger[4] = new Gojo("Gojo", 1);
        choose[4] = false;
        this.tower = new Tower();
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Ranger[] getRanger() {
        return ranger;
    }

    public void setRanger(Ranger[] ranger) {
        this.ranger = ranger;
    }

    public boolean[] getChoose() {
        return choose;
    }

    public void setChoose(int idx, boolean ganti) {
        this.choose[idx] = ganti;
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }
        
}
