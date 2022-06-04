/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectpbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

/**
 *
 * @author RyanK
 */
public class Battle extends javax.swing.JFrame {
    private Music player = null;
    private boolean kemute = false;
    private boolean keplay = false;
    
    private ArrayList<User> u = new ArrayList<>();
    private int idx;
    
    // Declaration
    private ImageIcon erisBox = new ImageIcon("src\\images\\Eris box.png");
    private ImageIcon erisJalan = new ImageIcon("src\\images\\Eris Jalan Ingame.gif");
    private ImageIcon erisAttack = new ImageIcon("src\\images\\Eris gada blue meke ukurane 150px.gif");
    
    private ImageIcon yoimiyaBox = new ImageIcon("src\\images\\Yoimiya box.png");
    private ImageIcon yoimiyaJalan = new ImageIcon("src\\images\\Yoimiya Jalan Ingame.gif");
    private ImageIcon yoimiyaAttack = new ImageIcon("src\\images\\Yoimiya Attack Ingame.gif");
    
    private ImageIcon shogunBox = new ImageIcon("src\\images\\Shogun box.png");
    private ImageIcon shogunJalan = new ImageIcon("src\\images\\Raiden Shogun Jalan.gif");
    private ImageIcon shogunAttack = new ImageIcon("src\\images\\Yoimiya Attack Resize.gif");
    
    private ImageIcon marsBox = new ImageIcon("src\\images\\Eris box.png");
    private ImageIcon marsJalan = new ImageIcon("src\\images\\Eris box.gif");
    private ImageIcon marsAttack = new ImageIcon("src\\images\\Eris box.gif");
    
    private ImageIcon newcastleBox = new ImageIcon("src\\images\\Eris box.png");
    private ImageIcon newcastleJalan = new ImageIcon("src\\images\\Eris box.gif");
    private ImageIcon newcastleAttack = new ImageIcon("src\\images\\Eris box.gif");
    
    private Ranger[] ranger = new Ranger[3];
    
    private ArrayList<JLabel> lblRanger = new ArrayList<>();
    private ArrayList<Integer> lblHpRanger = new ArrayList<>();
    private Timer tJalan;
    private Timer tAttack;
    
    // Prize
    private int prize = 0;
    
    // Mineral
    private int curMana = 0;
    private Timer tMana = null;
    
    // Cooldown tower skill
    private int CD = 0;
    private int maxCD;
    private Timer tCDTower = null;
    
    // Enemy
    private ArrayList<JLabel> lblEnemy = new ArrayList<>();
    private ArrayList<Integer> lblHpEnemy = new ArrayList<>();
    private Timer tEnemySpawn = null;
    private Timer tEnemyJalan = null;
    private Timer tEnemyAtt = null;
    
    private void stopTimer(){
        tMana.stop();
        tJalan.stop();
        tAttack.stop();
        tEnemySpawn.stop();
        tEnemyJalan.stop();
        tEnemyAtt.stop();
        tCDTower.stop();
    }
    /**
     * Creates new form Battle
     */
    public Battle() {
        initComponents();
        this.setLocationRelativeTo(null);
        setLayout(null);
    }
    
    public Battle(ArrayList<User> players, int idx, Music player, boolean kemute, boolean keplay) {
        this.player = player;
        this.kemute = kemute;
        this.keplay = keplay;
        // Ganti Music
        if (!kemute){
            player.clip.stop();
            player.loadMusic("src/music/bgBattle.wav");
            FloatControl volume = (FloatControl) player.clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-10f);
            player.clip.setMicrosecondPosition(0);
            player.clip.start();
            player.clip.loop(Clip.LOOP_CONTINUOUSLY);
        }       
        
        this.u = players;
        this.idx = idx;
        int keisi = 0;
        // Cek Boolean
        for (int i = 0; i < 5; i++) {
            if (u.get(idx).getChoose()[i]){
                ranger[keisi] = u.get(idx).getRanger()[i];
                keisi++;
            }
        }
        
        initComponents();
        this.setLocationRelativeTo(null);
        setLayout(null);
        GAMEOVER.setVisible(false);
        btGameOver.setVisible(false);
        ketGameOver.setVisible(false);
        Prize.setVisible(false);
        
        // Mana config
        int maxMana=100;
        MaxMineral.setText(Integer.toString(maxMana));
        ActionListener actMana = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (curMana < maxMana){
                    curMana+=1;
                    CurMineral.setText(Integer.toString(curMana));
                }
            }
        };
        if (tMana == null){
            tMana = new Timer(75, actMana);
            tMana.start();
        }
        
        // Tower Config
        this.maxCD = 10;
        ActionListener actCDTower = new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (CD < maxCD){
                    CD++;
                    CoolDown.setText(Integer.toString(CD));
                }else{
                    CoolDown.setText("Ready");
                    tCDTower.stop();
                }
            }
        };
        if (tCDTower == null){
            tCDTower = new Timer(1000, actCDTower);
            tCDTower.start();
        }
        
        // Ranger Config
        int hpTower = u.get(idx).getTower().getHp();
        HpTowerRanger.setText(Integer.toString(hpTower));
        
        R1Cost.setText(Integer.toString(ranger[0].getMineral()));
        if (ranger[0] instanceof Eris)
            Ranger1.setIcon(erisBox);
        else if (ranger[0] instanceof Yoimiya)
            Ranger1.setIcon(yoimiyaBox);
        else if (ranger[0] instanceof RaidenShogun)
            Ranger1.setIcon(shogunBox);
        else if (ranger[0] instanceof Mars)
            Ranger1.setIcon(marsBox);
        else if (ranger[0] instanceof NewCastle)
            Ranger1.setIcon(newcastleBox);
        
        R2Cost.setText(Integer.toString(ranger[1].getMineral()));
        if (ranger[1] instanceof Eris)
            Ranger2.setIcon(erisBox);
        else if (ranger[1] instanceof Yoimiya)
            Ranger2.setIcon(yoimiyaBox);
        else if (ranger[1] instanceof RaidenShogun)
            Ranger2.setIcon(shogunBox);
        else if (ranger[1] instanceof Mars)
            Ranger2.setIcon(marsBox);
        else if (ranger[1] instanceof NewCastle)
            Ranger2.setIcon(newcastleBox);
        
        R3Cost.setText(Integer.toString(ranger[2].getMineral()));
        if (ranger[2] instanceof Eris)
            Ranger3.setIcon(erisBox);
        else if (ranger[2] instanceof Yoimiya)
            Ranger3.setIcon(yoimiyaBox);
        else if (ranger[2] instanceof RaidenShogun)
            Ranger3.setIcon(shogunBox);
        else if (ranger[2] instanceof Mars)
            Ranger3.setIcon(marsBox);
        else if (ranger[2] instanceof NewCastle)
            Ranger3.setIcon(newcastleBox);
        
        // Tower Enemy Config
        Tower towerEnemy = new Tower(2500, 1, false);
        HpTowerEnemy.setText(Integer.toString(towerEnemy.getHp()));
        
        // Ranger Config
        //// Jalan
        ActionListener actJalan = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lblRanger.size(); i++) {
                    int posx = lblRanger.get(i).getLocation().x;
                    int posy = lblRanger.get(i).getLocation().y;
                    if (lblRanger.get(i).getIcon().equals(erisJalan)){
                        // Depan Enemy
                        boolean jalan = true;
                        for (int j = 0; j < lblEnemy.size(); j++) {
                            int eX = lblEnemy.get(j).getLocation().x;
                            int eY = lblEnemy.get(j).getLocation().y;
                            if (posx+165 >= eX){
                                jalan = false;
                            }
                        }
                        if (jalan){
                            if (posx+165 < 1070){
                                lblRanger.get(i).setLocation(posx+1, posy);
                            }else if (posx+165 == 1070){
                                lblRanger.get(i).setIcon(erisAttack);
                                lblRanger.get(i).setBounds(posx, posy-30, 165, 150);
                            }
                        }else{
                            lblRanger.get(i).setIcon(erisAttack);
                            lblRanger.get(i).setBounds(posx, posy-30, 165, 150);
                        }                        
                    }else if (lblRanger.get(i).getIcon().equals(yoimiyaJalan)){
                        // Depan Enemy
                        boolean jalan = true;
                        for (int j = 0; j < lblEnemy.size(); j++) {
                            int eX = lblEnemy.get(j).getLocation().x;
                            int eY = lblEnemy.get(j).getLocation().y;
                            if (posx+199 >= eX){
                                jalan = false;
                            }
                        }
                        if (jalan){
                            if (posx+199 < 1070){
                                lblRanger.get(i).setLocation(posx+1, posy);
                            }else if (posx+199 == 1070){
                                lblRanger.get(i).setIcon(yoimiyaAttack);
                                lblRanger.get(i).setBounds(posx, posy, 199, 120);
                            }
                        }else{
                            lblRanger.get(i).setIcon(yoimiyaAttack);
                            lblRanger.get(i).setBounds(posx, posy, 199, 120);
                        }
                    }else if (lblRanger.get(i).getIcon().equals(shogunJalan)){
                        
                    }else if (lblRanger.get(i).getIcon().equals(marsJalan)){
                        
                    }else if (lblRanger.get(i).getIcon().equals(newcastleJalan)){
                        
                    }
                }
            }
        };
        if (tJalan == null){
            tJalan = new Timer(10, actJalan);
            tJalan.start();
        }
        //// Attack
        ActionListener actAttack = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lblRanger.size(); i++) {
                    int posx = lblRanger.get(i).getLocation().x;
                    int posy = lblRanger.get(i).getLocation().y;
                    if (lblRanger.get(i).getIcon().equals(erisAttack)){
                        int demeg = u.get(idx).getRanger()[0].getDmg();
                        if (posx+165 == 1070){
                            int curHp = towerEnemy.getHp() - demeg;
                            towerEnemy.setHp(curHp);
                            HpTowerEnemy.setText(Integer.toString(curHp));
                        }else{
                            if (lblHpEnemy.size() >= 1 && posx+165 >= lblEnemy.get(0).getLocation().x){
                                if (!lblHpEnemy.isEmpty()){
                                    if (lblHpEnemy.get(0) <= 0){
                                        lblHpEnemy.remove(0);
                                        remove(lblEnemy.get(0));
                                        lblEnemy.remove(0);
                                        revalidate();
                                        repaint();
                                        lblRanger.get(i).setIcon(erisJalan);
                                        lblRanger.get(i).setBounds(posx, posy+30, 90, 120);
                                        i = -1;
                                    }else{
                                        lblHpEnemy.set(0, lblHpEnemy.get(0)-demeg);
                                    }
                                }else{
                                    lblRanger.get(i).setIcon(erisJalan);
                                    lblRanger.get(i).setBounds(posx, posy+30, 90, 120);
                                }
                            }else{
                                lblRanger.get(i).setIcon(erisJalan);
                                lblRanger.get(i).setBounds(posx, posy+30, 90, 120);
                            }
                        }
                    }else if (lblRanger.get(i).getIcon().equals(yoimiyaAttack)){
                        int demeg = u.get(idx).getRanger()[1].getDmg();
                        if (posx+199 == 1070){
                            int curHp = towerEnemy.getHp() - demeg;
                            towerEnemy.setHp(curHp);
                            HpTowerEnemy.setText(Integer.toString(curHp));
                        }else{
                            if (lblHpEnemy.size() >= 1 && posx+199 >= lblEnemy.get(0).getLocation().x){
                                if (!lblHpEnemy.isEmpty()){
                                    if (lblHpEnemy.get(0) <= 0){
                                        lblHpEnemy.remove(0);
                                        remove(lblEnemy.get(0));
                                        lblEnemy.remove(0);
                                        revalidate();
                                        repaint();
                                        lblRanger.get(i).setIcon(yoimiyaJalan);
                                        lblRanger.get(i).setBounds(posx, posy, 86, 120);
                                        i = -1;
                                    }else{
                                        lblHpEnemy.set(0, lblHpEnemy.get(0)-demeg);
                                    }
                                }else{
                                    lblRanger.get(i).setIcon(yoimiyaJalan);
                                    lblRanger.get(i).setBounds(posx, posy, 86, 120);
                                }
                            }else{
                                lblRanger.get(i).setIcon(yoimiyaJalan);
                                lblRanger.get(i).setBounds(posx, posy, 86, 120);
                            }                            
                        }
                    }else if (lblRanger.get(i).getIcon().equals(shogunAttack)){
                        
                    }else if (lblRanger.get(i).getIcon().equals(marsAttack)){
                        
                    }else if (lblRanger.get(i).getIcon().equals(newcastleAttack)){
                        
                    }
                }
                // Cek GameOver
                if (towerEnemy.getHp()<=0){
                    towerEnemy.setHp(0);
                    HpTowerEnemy.setText("0");
                    stopTimer();
                    GAMEOVER.setVisible(true);
                    btGameOver.setVisible(true);
                    ketGameOver.setVisible(true);
                    prize = 1000;
                    u.get(idx).setGold(u.get(idx).getGold() + prize);
                    u.get(idx).setLevel(u.get(idx).getLevel() + 1);
                    Prize.setText("You Win! You got "+prize+" Gold!");
                    Prize.setVisible(true);
                }
            }
        };
        if (tAttack == null){
            tAttack = new Timer(500, actAttack);
            tAttack.start();
        }
        
        // Enemy Config
        Enemy enemy = new Enemy(1, 300, 50);
        //// Spawn
        ActionListener actSpawnEnemy = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblEnemy.add(new JLabel());
                lblEnemy.get(lblEnemy.size()-1).setIcon(yoimiyaJalan);
                lblEnemy.get(lblEnemy.size()-1).setBounds(944, 430, 86, 120);
                getContentPane().add(lblEnemy.get(lblEnemy.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1),1);
                lblHpEnemy.add(enemy.getHp());
            }
        };
        if (tEnemySpawn == null){
            tEnemySpawn = new Timer(7000, actSpawnEnemy);
            tEnemySpawn.start();
        }
        //// Jalan
        ActionListener actJalanEnemy = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lblEnemy.size(); i++) {
                    int Ex = lblEnemy.get(i).getLocation().x;
                    int Ey = lblEnemy.get(i).getLocation().y;
                    boolean jalan = true;
                    for (int j = 0; j < lblRanger.size(); j++) {
                        int rangX = lblRanger.get(j).getLocation().x;
                        int rangY = lblRanger.get(j).getLocation().y;
                        if (Ex <= rangX+lblRanger.get(j).getBounds().width){
                            jalan = false;
                        }
                    }
                    if (jalan){
                        if (lblEnemy.get(i).getIcon().equals(yoimiyaJalan)){
                            if (Ex > 215){
                                lblEnemy.get(i).setLocation(Ex-1, Ey);
                            }else if (Ex == 215){
                                lblEnemy.get(i).setIcon(yoimiyaAttack);
                                lblEnemy.get(i).setBounds(Ex, Ey, 199, 120);
                            }
                        }
                    }else{
                        lblEnemy.get(i).setIcon(yoimiyaAttack);
                        lblEnemy.get(i).setBounds(Ex, Ey, 199, 120);
                    }
                }
            }
        };
        if (tEnemyJalan == null){
            tEnemyJalan = new Timer(10, actJalanEnemy);
            tEnemyJalan.start();
        }
        //// Attack
        ActionListener actAttackEnemy = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lblEnemy.size(); i++) {
                    int Ex = lblEnemy.get(i).getLocation().x;
                    int Ey = lblEnemy.get(i).getLocation().y;
                    if (lblEnemy.get(i).getIcon().equals(yoimiyaAttack)){
                        int demeg = enemy.getDmg();
                        if (Ex == 215){
                            int curHp = u.get(idx).getTower().getHp() - demeg;
                            u.get(idx).getTower().setHp(curHp);
                            HpTowerRanger.setText(Integer.toString(curHp));
                        }else{
                            if (lblHpRanger.size() >= 1 && Ex <= lblRanger.get(0).getLocation().x+lblRanger.get(0).getBounds().width){
                                if (!lblHpRanger.isEmpty()){
                                    lblHpRanger.set(0, lblHpRanger.get(0)-demeg);
                                    if (lblHpRanger.get(0) <= 0){                              
                                        lblHpRanger.remove(0);
                                        remove(lblRanger.get(0));
                                        lblRanger.remove(0);
                                        revalidate();
                                        repaint();
                                        lblEnemy.get(i).setIcon(yoimiyaJalan);
                                        lblEnemy.get(i).setBounds(Ex, Ey, 86, 120);
                                    }
                                }else{
                                    lblEnemy.get(i).setIcon(yoimiyaJalan);
                                    lblEnemy.get(i).setBounds(Ex, Ey, 86, 120);
                                }
                            }else{
                                lblEnemy.get(i).setIcon(yoimiyaJalan);
                                lblEnemy.get(i).setBounds(Ex, Ey, 86, 120);
                            }                             
                        }
                    }
                }
                // Cek GameOver
                if (u.get(idx).getTower().getHp()<=0){
                    u.get(idx).getTower().setHp(hpTower);
                    HpTowerRanger.setText("0");
                    stopTimer();
                    GAMEOVER.setVisible(true);
                    btGameOver.setVisible(true);
                    ketGameOver.setVisible(true);
                    Prize.setText("You Lose! You got 0 Gold!");
                    Prize.setVisible(true);
                }
            }
        };
        if (tEnemyAtt == null){
            tEnemyAtt = new Timer(500, actAttackEnemy);
            tEnemyAtt.start();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Prize = new javax.swing.JLabel();
        GAMEOVER = new javax.swing.JLabel();
        ketGameOver = new javax.swing.JLabel();
        btPause = new javax.swing.JButton();
        R3Cost = new javax.swing.JLabel();
        Ranger3 = new javax.swing.JButton();
        R2Cost = new javax.swing.JLabel();
        Ranger2 = new javax.swing.JButton();
        R1Cost = new javax.swing.JLabel();
        Ranger1 = new javax.swing.JButton();
        CurMineral = new javax.swing.JLabel();
        MaxMineral = new javax.swing.JLabel();
        BoxMineral = new javax.swing.JLabel();
        BoxRangers = new javax.swing.JLabel();
        HpTowerEnemy = new javax.swing.JLabel();
        HPTEnemyBorder = new javax.swing.JLabel();
        HpTowerRanger = new javax.swing.JLabel();
        HPTRangerBorder = new javax.swing.JLabel();
        CoolDown = new javax.swing.JLabel();
        btTowerAtt = new javax.swing.JButton();
        TowerEnemy = new javax.swing.JLabel();
        TowerPlayer = new javax.swing.JLabel();
        btGameOver = new javax.swing.JButton();
        BgBattle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rangers Wars");
        setLocation(new java.awt.Point(325, 180));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Prize.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        Prize.setForeground(new java.awt.Color(255, 204, 51));
        Prize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Prize.setText("You got 0000 Gold");
        getContentPane().add(Prize, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 300, 490, -1));

        GAMEOVER.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 90)); // NOI18N
        GAMEOVER.setForeground(new java.awt.Color(255, 0, 0));
        GAMEOVER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GAMEOVER.setText("GAME OVER");
        getContentPane().add(GAMEOVER, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 135, -1, -1));

        ketGameOver.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        ketGameOver.setForeground(new java.awt.Color(255, 0, 0));
        ketGameOver.setText("Tap Anywhere to Continue");
        getContentPane().add(ketGameOver, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 230, -1, -1));

        btPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol Pause.png"))); // NOI18N
        btPause.setBorderPainted(false);
        btPause.setContentAreaFilled(false);
        btPause.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPauseActionPerformed(evt);
            }
        });
        getContentPane().add(btPause, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, -1, -1));

        R3Cost.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        R3Cost.setForeground(new java.awt.Color(255, 255, 255));
        R3Cost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        R3Cost.setText("0000");
        getContentPane().add(R3Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 690, -1, -1));

        Ranger3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Box rangers.png"))); // NOI18N
        Ranger3.setBorderPainted(false);
        Ranger3.setContentAreaFilled(false);
        Ranger3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ranger3ActionPerformed(evt);
            }
        });
        getContentPane().add(Ranger3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 600, -1, -1));

        R2Cost.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        R2Cost.setForeground(new java.awt.Color(255, 255, 255));
        R2Cost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        R2Cost.setText("0000");
        getContentPane().add(R2Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 690, -1, -1));

        Ranger2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Box rangers.png"))); // NOI18N
        Ranger2.setBorderPainted(false);
        Ranger2.setContentAreaFilled(false);
        Ranger2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ranger2ActionPerformed(evt);
            }
        });
        getContentPane().add(Ranger2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 600, -1, -1));

        R1Cost.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        R1Cost.setForeground(new java.awt.Color(255, 255, 255));
        R1Cost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        R1Cost.setText("0000");
        R1Cost.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(R1Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 690, -1, -1));

        Ranger1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Box rangers.png"))); // NOI18N
        Ranger1.setBorderPainted(false);
        Ranger1.setContentAreaFilled(false);
        Ranger1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Ranger1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ranger1ActionPerformed(evt);
            }
        });
        getContentPane().add(Ranger1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 600, -1, -1));

        CurMineral.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 28)); // NOI18N
        CurMineral.setForeground(new java.awt.Color(255, 255, 255));
        CurMineral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CurMineral.setText("000");
        getContentPane().add(CurMineral, new org.netbeans.lib.awtextra.AbsoluteConstraints(956, 607, 90, -1));

        MaxMineral.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 28)); // NOI18N
        MaxMineral.setForeground(new java.awt.Color(0, 255, 255));
        MaxMineral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MaxMineral.setText("000");
        getContentPane().add(MaxMineral, new org.netbeans.lib.awtextra.AbsoluteConstraints(956, 655, 90, 30));

        BoxMineral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Mineral box.png"))); // NOI18N
        getContentPane().add(BoxMineral, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 590, -1, -1));

        BoxRangers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BoxRangers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Box untuk rangers 3.png"))); // NOI18N
        BoxRangers.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(BoxRangers, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, -1, 140));

        HpTowerEnemy.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        HpTowerEnemy.setForeground(new java.awt.Color(0, 0, 0));
        HpTowerEnemy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HpTowerEnemy.setText("000");
        getContentPane().add(HpTowerEnemy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1145, 615, 80, -1));

        HPTEnemyBorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Nyawa Tower Musuh.png"))); // NOI18N
        getContentPane().add(HPTEnemyBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 600, -1, -1));

        HpTowerRanger.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        HpTowerRanger.setForeground(new java.awt.Color(0, 0, 0));
        HpTowerRanger.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HpTowerRanger.setText("000");
        getContentPane().add(HpTowerRanger, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 615, 80, -1));

        HPTRangerBorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Nyawa tower rangers.png"))); // NOI18N
        getContentPane().add(HPTRangerBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, -1, -1));

        CoolDown.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        CoolDown.setForeground(new java.awt.Color(0, 0, 0));
        CoolDown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CoolDown.setText("Ready");
        getContentPane().add(CoolDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 641, 70, -1));

        btTowerAtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tower Attack.png"))); // NOI18N
        btTowerAtt.setBorderPainted(false);
        btTowerAtt.setContentAreaFilled(false);
        btTowerAtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTowerAttActionPerformed(evt);
            }
        });
        getContentPane().add(btTowerAtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, -1, -1));

        TowerEnemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tower Musuh.png"))); // NOI18N
        getContentPane().add(TowerEnemy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 380, -1, -1));

        TowerPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tower Rangers.png"))); // NOI18N
        getContentPane().add(TowerPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        btGameOver.setBorderPainted(false);
        btGameOver.setContentAreaFilled(false);
        btGameOver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGameOverActionPerformed(evt);
            }
        });
        getContentPane().add(btGameOver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        BgBattle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Background Habis login revisi.gif"))); // NOI18N
        getContentPane().add(BgBattle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    private void btPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPauseActionPerformed
        if (!kemute){
            player.clip.stop();
            player.loadMusic("src/music/bg.wav");
            FloatControl volume = (FloatControl) player.clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-10f);
            player.clip.setMicrosecondPosition(0);
            player.clip.start();
            player.clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        stopTimer();
        dispose();
        new Game(u, idx, player, kemute, keplay).setVisible(true);
    }//GEN-LAST:event_btPauseActionPerformed

    private void Ranger1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ranger1ActionPerformed
        int cost = ranger[0].getMineral();
        if (curMana > cost){
            curMana -= cost;
            
            lblRanger.add(new JLabel());
            // Cek Icon
            ImageIcon troopJalan = null;
            int x = 0;
            int y = 0;
            int width = 0;
            int height = 0;
            if (ranger[0] instanceof Eris){
                troopJalan = erisJalan;
                x = 210;
                y = 430;
                width = 90;
                height = 120;
            }else if (ranger[0] instanceof Yoimiya){
                troopJalan = yoimiyaJalan;
                x = 210;
                y = 430;
                width = 86;
                height = 120;
            }else if (ranger[0] instanceof RaidenShogun){
                troopJalan = shogunJalan;
                x = 210;
                y = 430;
                width = 140;
                height = 120;
            }else if (ranger[0] instanceof Mars)
                troopJalan = marsJalan;
            else if (ranger[0] instanceof NewCastle)
                troopJalan = newcastleJalan;

            // Setting
            lblRanger.get(lblRanger.size()-1).setIcon(troopJalan);
            lblRanger.get(lblRanger.size()-1).setBounds(x, y, width, height);
            getContentPane().add(lblRanger.get(lblRanger.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1),1);
            lblHpRanger.add(ranger[0].getHp());
        }
    }//GEN-LAST:event_Ranger1ActionPerformed

    private void Ranger2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ranger2ActionPerformed
        int cost = ranger[1].getMineral();
        if (curMana > cost){
            curMana -= cost;
            
            lblRanger.add(new JLabel());
            // Cek Icon
            ImageIcon troopJalan = null;
            int x = 0;
            int y = 0;
            int width = 0;
            int height = 0;
            if (ranger[1] instanceof Eris){
                troopJalan = erisJalan;
                x = 210;
                y = 430;
                width = 90;
                height = 120;
            }else if (ranger[1] instanceof Yoimiya){
                troopJalan = yoimiyaJalan;
                x = 210;
                y = 430;
                width = 86;
                height = 120;
            }else if (ranger[1] instanceof RaidenShogun){
                troopJalan = shogunJalan;
                x = 210;
                y = 430;
                width = 140;
                height = 120;
            }else if (ranger[1] instanceof Mars)
                troopJalan = marsJalan;
            else if (ranger[1] instanceof NewCastle)
                troopJalan = newcastleJalan;

            // Setting
            lblRanger.get(lblRanger.size()-1).setIcon(troopJalan);
            lblRanger.get(lblRanger.size()-1).setBounds(x, y, width, height);
            getContentPane().add(lblRanger.get(lblRanger.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1),1);
            lblHpRanger.add(ranger[1].getHp());
        }
    }//GEN-LAST:event_Ranger2ActionPerformed

    private void Ranger3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ranger3ActionPerformed
        int cost = ranger[2].getMineral();
        if (curMana > cost){
            curMana -= cost;
            
            lblRanger.add(new JLabel());
            // Cek Icon
            ImageIcon troopJalan = null;
            int x = 0;
            int y = 0;
            int width = 0;
            int height = 0;
            if (ranger[2] instanceof Eris){
                troopJalan = erisJalan;
                x = 210;
                y = 430;
                width = 90;
                height = 120;
            }else if (ranger[2] instanceof Yoimiya){
                troopJalan = yoimiyaJalan;
                x = 210;
                y = 430;
                width = 86;
                height = 120;
            }else if (ranger[2] instanceof RaidenShogun){
                troopJalan = shogunJalan;
                x = 210;
                y = 430;
                width = 140;
                height = 120;
            }else if (ranger[2] instanceof Mars)
                troopJalan = marsJalan;
            else if (ranger[2] instanceof NewCastle)
                troopJalan = newcastleJalan;

            // Setting
            lblRanger.get(lblRanger.size()-1).setIcon(troopJalan);
            lblRanger.get(lblRanger.size()-1).setBounds(x, y, width, height);
            getContentPane().add(lblRanger.get(lblRanger.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1),1);
            lblHpRanger.add(ranger[2].getHp());
        }
    }//GEN-LAST:event_Ranger3ActionPerformed

    private void btGameOverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGameOverActionPerformed
        if (!kemute){
            player.clip.stop();
            player.loadMusic("src/music/bg.wav");
            FloatControl volume = (FloatControl) player.clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-10f);
            player.clip.setMicrosecondPosition(0);
            player.clip.start();
            player.clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        dispose();
        new Game(u, idx, player, kemute, keplay).setVisible(true);
    }//GEN-LAST:event_btGameOverActionPerformed

    private void btTowerAttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTowerAttActionPerformed
        if (CD == maxCD){
            for (int i = lblEnemy.size()-1; i >= 0 ; i--) {
                remove(lblEnemy.get(i));
                lblEnemy.remove(i);
                revalidate();
                repaint();
            }
            lblHpEnemy.clear();
            CD = 0;
            CoolDown.setText("0");
            tCDTower.start();
        }
    }//GEN-LAST:event_btTowerAttActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Battle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BgBattle;
    private javax.swing.JLabel BoxMineral;
    private javax.swing.JLabel BoxRangers;
    private javax.swing.JLabel CoolDown;
    private javax.swing.JLabel CurMineral;
    private javax.swing.JLabel GAMEOVER;
    private javax.swing.JLabel HPTEnemyBorder;
    private javax.swing.JLabel HPTRangerBorder;
    private javax.swing.JLabel HpTowerEnemy;
    private javax.swing.JLabel HpTowerRanger;
    private javax.swing.JLabel MaxMineral;
    private javax.swing.JLabel Prize;
    private javax.swing.JLabel R1Cost;
    private javax.swing.JLabel R2Cost;
    private javax.swing.JLabel R3Cost;
    private javax.swing.JButton Ranger1;
    private javax.swing.JButton Ranger2;
    private javax.swing.JButton Ranger3;
    private javax.swing.JLabel TowerEnemy;
    private javax.swing.JLabel TowerPlayer;
    private javax.swing.JButton btGameOver;
    private javax.swing.JButton btPause;
    private javax.swing.JButton btTowerAtt;
    private javax.swing.JLabel ketGameOver;
    // End of variables declaration//GEN-END:variables
}
