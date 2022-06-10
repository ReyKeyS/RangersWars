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
    private Music MainTheme = null;
    private boolean kemute = false;
    private boolean keplay = false;
    
    private Music BattleTheme = new Music("src\\music\\bgBattle.wav");
    private Music soundThunder = new Music("src\\music\\Thundergod's_Wrath.wav");
    
    private ArrayList<User> u = new ArrayList<>();
    private int idx;
    
    // Declaration
    private ImageIcon erisBox = new ImageIcon("src\\images\\Eris box.png");
    private ImageIcon erisJalan = new ImageIcon("src\\images\\Eris Jalan Ingame.gif");
    private ImageIcon erisAttack = new ImageIcon("src\\images\\Eris attack.gif");
    
    private ImageIcon yoimiyaBox = new ImageIcon("src\\images\\Yoimiya box.png");
    private ImageIcon yoimiyaJalan = new ImageIcon("src\\images\\Yoimiya Jalan Ingame.gif");
    private ImageIcon yoimiyaAttack = new ImageIcon("src\\images\\Yoimiya Attack Ingame.gif");
    
    private ImageIcon shogunBox = new ImageIcon("src\\images\\Shogun box.png");
    private ImageIcon shogunJalan = new ImageIcon("src\\images\\Raiden Shogun Jalan.gif");
    private ImageIcon shogunAttack = new ImageIcon("src\\images\\Raiden Shogun Att.gif");
    
    private ImageIcon marsBox = new ImageIcon("src\\images\\Eris box.png");
    private ImageIcon marsJalan = new ImageIcon("src\\images\\Eris box.gif");
    private ImageIcon marsAttack = new ImageIcon("src\\images\\Eris box.gif");
    
    private ImageIcon newcastleBox = new ImageIcon("src\\images\\Eris box.png");
    private ImageIcon newcastleJalan = new ImageIcon("src\\images\\Eris box.gif");
    private ImageIcon newcastleAttack = new ImageIcon("src\\images\\Eris box.gif");
    
    private ImageIcon pentolJalan = new ImageIcon("src\\images\\PentolJalan.gif");
    private ImageIcon pentolAttack = new ImageIcon("src\\images\\PentolAttack.gif");
    
    private Ranger[] ranger = new Ranger[3];
    
    private ArrayList<JLabel> lblRanger = new ArrayList<>();
    private ArrayList<Integer> lblHpRanger = new ArrayList<>();
    private Timer tJalan;
    private Timer tAttack;
    
    // Prize
    private int prize = 0;
    
    // Mineral
    private int curMana = 0;
    private int manaRate;
    private int manaMax;
    private Timer tMana = null;
    
    // Cooldown tower skill
    private int hpTower;
    private int CD = 0;
    private int maxCD = 10;
    private Timer tCDTower = null;
    private Timer animasiTower = null;
    private int waktu = 0;
    
    // Enemy
    private ArrayList<JLabel> lblEnemy = new ArrayList<>();
    private ArrayList<Integer> lblHpEnemy = new ArrayList<>();
    private Timer tEnemySpawn = null;
    private Timer tEnemyJalan = null;
    private Timer tEnemyAtt = null;
    private int towerEnemy;
    private int spawnCD = 0;
    private int spawnMaxCD = 3;
    
    private void stopTimer(){
        tMana.stop();
        tJalan.stop();
        tAttack.stop();
        tEnemySpawn.stop();
        tEnemyJalan.stop();
        tEnemyAtt.stop();
        tCDTower.stop();
        if (animasiTower != null){
            animasiTower.stop();
        }
    }
    /**
     * Creates new form Battle
     */
    public Battle() {
        initComponents();
        this.setLocationRelativeTo(null);
        setLayout(null);
    }
    
    public Battle(ArrayList<User> players, int idx, Music MainTheme, boolean kemute, boolean keplay) {
        this.MainTheme = MainTheme;
        this.kemute = kemute;
        this.keplay = keplay;
        // Ganti Music
        if (!kemute){
            MainTheme.Clip().stop();
            FloatControl volume = (FloatControl) BattleTheme.Clip().getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-10f);
            BattleTheme.Clip().setMicrosecondPosition(0);
            BattleTheme.Clip().start();
            BattleTheme.Clip().loop(Clip.LOOP_CONTINUOUSLY);
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
        black.setVisible(false);
        
        // Tower Enemy Config
        towerEnemy = 900 + u.get(idx).getLevel()*100;
        HpTowerEnemy.setText(Integer.toString(towerEnemy));
        
        // Mana config
        this.manaRate = u.get(idx).getTower().getMineralRate();
        this.manaMax = u.get(idx).getTower().getMineralMax();
        MaxMineral.setText(Integer.toString(manaMax));
        ActionListener actMana = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (curMana < manaMax){
                    curMana += manaRate;
                    CurMineral.setText(Integer.toString(curMana));
                }
            }
        };
        if (tMana == null){
            tMana = new Timer(150, actMana);
            tMana.start();
        }
        
        // Tower Config
        ActionListener actCDTower = new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (CD < maxCD){
                    CD++;
                    CoolDown.setText(Integer.toString(CD));
                    if (CD == maxCD){
                        CoolDown.setText("Ready");
                    }
                }else if (CD == maxCD){
                    tCDTower.stop();
                }
            }
        };
        if (tCDTower == null){
            tCDTower = new Timer(1000, actCDTower);
            tCDTower.start();
        }
        this.hpTower = u.get(idx).getTower().getHp();
        HpTowerRanger.setText(Integer.toString(hpTower));
        
        // Ranger Config
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
                            if (posx+175 >= eX+71){
                                jalan = false;
                            }
                        }
                        if (jalan){
                            if (posx+175 < 1070){
                                lblRanger.get(i).setLocation(posx+1, posy);
                            }else if (posx+175 == 1070){
                                lblRanger.get(i).setIcon(erisAttack);
                                lblRanger.get(i).setBounds(posx-30, posy-26, 175, 160);
                            }
                        }else{
                            lblRanger.get(i).setIcon(erisAttack);
                            lblRanger.get(i).setBounds(posx-30, posy-26, 175, 160);
                        }                        
                    }else if (lblRanger.get(i).getIcon().equals(yoimiyaJalan)){
                        // Depan Enemy
                        boolean jalan = true;
                        for (int j = 0; j < lblEnemy.size(); j++) {
                            int eX = lblEnemy.get(j).getLocation().x;
                            int eY = lblEnemy.get(j).getLocation().y;
                            if (posx+199 >= eX+71){
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
                        // Depan Enemy
                        boolean jalan = true;
                        for (int j = 0; j < lblEnemy.size(); j++) {
                            int eX = lblEnemy.get(j).getLocation().x;
                            int eY = lblEnemy.get(j).getLocation().y;
                            if (posx+244 >= eX+71){
                                jalan = false;
                            }
                        }
                        if (jalan){
                            if (posx+244 < 1070){
                                lblRanger.get(i).setLocation(posx+1, posy);
                            }else if (posx+244 == 1070){
                                lblRanger.get(i).setIcon(shogunAttack);
                                lblRanger.get(i).setBounds(posx+20, posy-75, 244, 202);
                            }
                        }else{
                            lblRanger.get(i).setIcon(shogunAttack);
                            lblRanger.get(i).setBounds(posx+20, posy-75, 244, 202);
                        }
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
                        if (posx+175 == 1070-30){
                            towerEnemy -= demeg;
                            HpTowerEnemy.setText(Integer.toString(towerEnemy));
                        }else{
                            if (lblHpEnemy.size() >= 1 && posx+175 >= lblEnemy.get(0).getLocation().x + 71){
                                if (!lblHpEnemy.isEmpty()){
                                    if (lblHpEnemy.get(0) <= 0){
                                        lblHpEnemy.remove(0);
                                        remove(lblEnemy.get(0));
                                        lblEnemy.remove(0);
                                        revalidate();
                                        repaint();
                                        lblRanger.get(i).setIcon(erisJalan);
                                        lblRanger.get(i).setBounds(posx+30, posy+26, 90, 120);
                                        i = -1;
                                    }else{
                                        lblHpEnemy.set(0, lblHpEnemy.get(0)-demeg);
                                    }
                                }else{
                                    lblRanger.get(i).setIcon(erisJalan);
                                    lblRanger.get(i).setBounds(posx+30, posy+26, 90, 120);
                                }
                            }else{
                                lblRanger.get(i).setIcon(erisJalan);
                                lblRanger.get(i).setBounds(posx+30, posy+26, 90, 120);
                            }
                        }
                    }else if (lblRanger.get(i).getIcon().equals(yoimiyaAttack)){
                        int demeg = u.get(idx).getRanger()[1].getDmg();
                        if (posx+199 == 1070){
                            towerEnemy -= demeg;
                            HpTowerEnemy.setText(Integer.toString(towerEnemy));
                        }else{
                            if (lblHpEnemy.size() >= 1 && posx+199 >= lblEnemy.get(0).getLocation().x + 71){
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
                        int demeg = u.get(idx).getRanger()[2].getDmg();
                        if (posx+244 == 1070-20){
                            towerEnemy -= demeg;
                            HpTowerEnemy.setText(Integer.toString(towerEnemy));
                        }else{
                            if (lblHpEnemy.size() >= 1 && posx+244 >= lblEnemy.get(0).getLocation().x + 71){
                                if (!lblHpEnemy.isEmpty()){
                                    if (lblHpEnemy.get(0) <= 0){
                                        lblHpEnemy.remove(0);
                                        remove(lblEnemy.get(0));
                                        lblEnemy.remove(0);
                                        revalidate();
                                        repaint();
                                        lblRanger.get(i).setIcon(shogunJalan);
                                        lblRanger.get(i).setBounds(posx-20, posy+75, 140, 120);
                                        i = -1;
                                    }else{
                                        lblHpEnemy.set(0, lblHpEnemy.get(0)-demeg);
                                    }
                                }else{
                                    lblRanger.get(i).setIcon(shogunJalan);
                                    lblRanger.get(i).setBounds(posx-20, posy+75, 140, 120);
                                }
                            }else{
                                lblRanger.get(i).setIcon(shogunJalan);
                                lblRanger.get(i).setBounds(posx-20, posy+75, 140, 120);
                            }
                        }
                    }else if (lblRanger.get(i).getIcon().equals(marsAttack)){
                        
                    }else if (lblRanger.get(i).getIcon().equals(newcastleAttack)){
                        
                    }
                }
                // Cek GameOver
                if (towerEnemy<=0){
                    towerEnemy=0;
                    HpTowerEnemy.setText("0");
                    stopTimer();
                    GAMEOVER.setVisible(true);
                    btGameOver.setVisible(true);
                    ketGameOver.setVisible(true);
                    prize += u.get(idx).getLevel()*10;
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
        Enemy enemy = new Enemy(u.get(idx).getLevel());
        
        //// Spawn
        ActionListener actSpawnEnemy = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spawnCD++;
                if (spawnCD == spawnMaxCD){
                    lblEnemy.add(new JLabel());
                    lblEnemy.get(lblEnemy.size()-1).setIcon(pentolJalan);
                    lblEnemy.get(lblEnemy.size()-1).setBounds(902, 430, 168, 120);
                    lblEnemy.get(lblEnemy.size()-1).setHorizontalAlignment(JLabel.RIGHT);
                    getContentPane().add(lblEnemy.get(lblEnemy.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1),1);
                    lblHpEnemy.add(enemy.getHp());
                    spawnCD = 0;
                    if (spawnMaxCD == 3){
                        spawnMaxCD = 7;
                    }else{
                        spawnMaxCD--;
                        if (spawnMaxCD == 2){
                            spawnMaxCD = 7;
                        }
                    }
                }
            }
        };
        if (tEnemySpawn == null){
            tEnemySpawn = new Timer(1000, actSpawnEnemy);
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
                        if (Ex-95 <= rangX){
                            jalan = false;
                        }
                    }
                    if (jalan){
                        if (lblEnemy.get(i).getIcon().equals(pentolJalan)){
                            if (Ex-95 > 200-95){
                                lblEnemy.get(i).setLocation(Ex-1, Ey);
                            }else if (Ex-95 == 200-95){
                                lblEnemy.get(i).setIcon(pentolAttack);
                            }
                        }
                    }else{
                        lblEnemy.get(i).setIcon(pentolAttack);
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
                    if (lblEnemy.get(i).getIcon().equals(pentolAttack)){
                        int demeg = enemy.getDmg();
                        if (Ex-95 == 200-95){
                            hpTower -= demeg;
                            HpTowerRanger.setText(Integer.toString(hpTower));
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
                                        lblEnemy.get(i).setIcon(pentolJalan);
                                    }
                                }else{
                                    lblEnemy.get(i).setIcon(pentolJalan);
                                }
                            }else{
                                lblEnemy.get(i).setIcon(pentolJalan);
                            }                             
                        }
                    }
                }
                // Cek GameOver
                if (hpTower<=0){
                    HpTowerRanger.setText("0");
                    stopTimer();
                    GAMEOVER.setVisible(true);
                    btGameOver.setVisible(true);
                    ketGameOver.setVisible(true);
                    prize += u.get(idx).getLevel()*10 / 4;
                    u.get(idx).setGold(u.get(idx).getGold() + prize);                    
                    Prize.setText("You Lose! You got "+prize+" Gold!");
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

        Thunder = new javax.swing.JLabel();
        black = new javax.swing.JLabel();
        Prize = new javax.swing.JLabel();
        GAMEOVER = new javax.swing.JLabel();
        ketGameOver = new javax.swing.JLabel();
        btStop = new javax.swing.JButton();
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
        getContentPane().add(Thunder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        black.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/black.png"))); // NOI18N
        getContentPane().add(black, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        btStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol Exit Ingame.png"))); // NOI18N
        btStop.setBorderPainted(false);
        btStop.setContentAreaFilled(false);
        btStop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStopActionPerformed(evt);
            }
        });
        getContentPane().add(btStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, -1, -1));

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
        HpTowerEnemy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HpTowerEnemy.setText("000");
        getContentPane().add(HpTowerEnemy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1145, 615, 80, -1));

        HPTEnemyBorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Nyawa Tower Musuh.png"))); // NOI18N
        getContentPane().add(HPTEnemyBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 600, -1, -1));

        HpTowerRanger.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        HpTowerRanger.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HpTowerRanger.setText("000");
        getContentPane().add(HpTowerRanger, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 615, 80, -1));

        HPTRangerBorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Nyawa tower rangers.png"))); // NOI18N
        getContentPane().add(HPTRangerBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, -1, -1));

        CoolDown.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        CoolDown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CoolDown.setText("0");
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
       
    private void btStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStopActionPerformed
        if (!kemute){
            BattleTheme.Clip().stop();
            FloatControl volume = (FloatControl) MainTheme.Clip().getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-10f);
            MainTheme.Clip().setMicrosecondPosition(0);
            MainTheme.Clip().start();
            MainTheme.Clip().loop(Clip.LOOP_CONTINUOUSLY);
        }
        stopTimer();
        dispose();
        new Game(u, idx, MainTheme, kemute, keplay).setVisible(true);
    }//GEN-LAST:event_btStopActionPerformed

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
            BattleTheme.Clip().stop();
            FloatControl volume = (FloatControl) MainTheme.Clip().getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-10f);
            MainTheme.Clip().setMicrosecondPosition(0);
            MainTheme.Clip().start();
            MainTheme.Clip().loop(Clip.LOOP_CONTINUOUSLY);
        }
        dispose();
        new Game(u, idx, MainTheme, kemute, keplay).setVisible(true);
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
            if (!kemute){
                FloatControl volume = (FloatControl) soundThunder.Clip().getControl(FloatControl.Type.MASTER_GAIN);
                volume.setValue(-10f);
                soundThunder.Clip().setMicrosecondPosition(0);
                soundThunder.Clip().start();
            }
            waktu = 0;
            black.setVisible(true);
            Thunder.setIcon(new ImageIcon("src\\images\\animasi thunder.gif"));
            ActionListener animasiT = new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    waktu++;
                    if (waktu < 5){
                        Thunder.setVisible(true);
                    }else if (waktu == 5){
                        Thunder.setVisible(false);
                        black.setVisible(false);
                    }
                }
            };
            if (animasiTower == null){
                animasiTower = new Timer(100, animasiT);
                animasiTower.start();
            }
            
            maxCD += 5;
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
    private javax.swing.JLabel Thunder;
    private javax.swing.JLabel TowerEnemy;
    private javax.swing.JLabel TowerPlayer;
    private javax.swing.JLabel black;
    private javax.swing.JButton btGameOver;
    private javax.swing.JButton btStop;
    private javax.swing.JButton btTowerAtt;
    private javax.swing.JLabel ketGameOver;
    // End of variables declaration//GEN-END:variables
}
