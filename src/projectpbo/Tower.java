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
public class Tower implements Serializable{
    private int hp;
    private int levelHp;
    private int levelRate;
    private int levelMax;
    private int goldCost;
    private int mineralRate;
    private int mineralMax;

    public Tower(int level) {
        this.hp = 600 + level*100;
        this.levelHp = level;
        this.levelRate = level;
        this.levelMax = level;
        this.goldCost = level * 10;
        this.mineralRate = 1;
        this.mineralMax = 100;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevelHp() {
        return levelHp;
    }

    public void setLevelHp(int levelHp) {
        this.levelHp = levelHp;
    }

    public int getLevelRate() {
        return levelRate;
    }

    public void setLevelRate(int levelRate) {
        this.levelRate = levelRate;
    }

    public int getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(int levelMax) {
        this.levelMax = levelMax;
    }
    
    public int getGoldCost() {
        return goldCost;
    }

    public void setGoldCost(int goldCost) {
        this.goldCost = goldCost;
    }

    public int getMineralRate() {
        return mineralRate;
    }

    public void setMineralRate(int mineralRate) {
        this.mineralRate = mineralRate;
    }

    public int getMineralMax() {
        return mineralMax;
    }

    public void setMineralMax(int mineralMax) {
        this.mineralMax = mineralMax;
    }
        
}
