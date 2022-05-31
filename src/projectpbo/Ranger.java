/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author RyanK
 */
public abstract class Ranger implements Serializable{
    protected String nama;
    protected int level;
    protected int hp;
    protected int dmg;
    protected int range;
    protected int movement;
    protected int mineral;
    protected ImageIcon iconKartu;
    protected ImageIcon iconJalan;
    protected ImageIcon iconAttack;

    public Ranger(String nama, int level, int hp, int dmg, int range, int movement, int mineral, ImageIcon iconKartu, ImageIcon iconJalan, ImageIcon iconAttack) {
        this.nama = nama;
        this.level = level;
        this.hp = hp;
        this.dmg = dmg;
        this.range = range;
        this.movement = movement;
        this.mineral = mineral;
        this.iconKartu = iconKartu;
        this.iconJalan = iconJalan;
        this.iconAttack = iconAttack;
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

    public ImageIcon getIconKartu() {
        return iconKartu;
    }

    public void setIconKartu(ImageIcon iconKartu) {
        this.iconKartu = iconKartu;
    }

    public ImageIcon getIconJalan() {
        return iconJalan;
    }

    public void setIconJalan(ImageIcon iconJalan) {
        this.iconJalan = iconJalan;
    }

    public ImageIcon getIconAttack() {
        return iconAttack;
    }

    public void setIconAttack(ImageIcon iconAttack) {
        this.iconAttack = iconAttack;
    }

}
