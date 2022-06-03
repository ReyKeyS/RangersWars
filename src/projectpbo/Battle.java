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
    private ImageIcon erisJalan = new ImageIcon("src\\images\\ErisJalan.gif");
    private ImageIcon erisAttack = new ImageIcon("src\\images\\Eris_Attack.gif");
    
    private ImageIcon yoimiyaBox = new ImageIcon("src\\images\\Yoimiya box.png");
    private ImageIcon yoimiyaJalan = new ImageIcon("src\\images\\Yoimiya Jalan Revisi.gif");
    private ImageIcon yoimiyaAttack = new ImageIcon("src\\images\\Yoimiya Attack Resize.gif");
    
    private ImageIcon shogunBox = new ImageIcon("src\\images\\Yoimiya box.png");
    private ImageIcon shogunJalan = new ImageIcon("src\\images\\Yoimiya Jalan Revisi.gif");
    private ImageIcon shogunAttack = new ImageIcon("src\\images\\Yoimiya Attack Resize.gif");
    
    private ImageIcon marsBox = new ImageIcon("src\\images\\Eris box.png");
    private ImageIcon marsJalan = new ImageIcon("src\\images\\Eris box.gif");
    private ImageIcon marsAttack = new ImageIcon("src\\images\\Eris box.gif");
    
    private ImageIcon newcastleBox = new ImageIcon("src\\images\\Eris box.png");
    private ImageIcon newcastleJalan = new ImageIcon("src\\images\\Eris box.gif");
    private ImageIcon newcastleAttack = new ImageIcon("src\\images\\Eris box.gif");
    
    private Ranger[] ranger = new Ranger[3];
    
    private ArrayList<JLabel> lblRanger = new ArrayList<>();
    private ArrayList<Integer> koor = new ArrayList<>();
    private Timer tJalan;
    private Timer tAttack;
    
    // Mineral
    private int curMana = 0;
    private Timer tMana = null;
    
    // Attacking
    private Timer tAtt = null;
    
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
        int hpTower = u.get(idx).getTower().getHp();
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
        
        
        // Ranger Config
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
        
        
        
        // Enemy Config
        Tower tEnemy = new Tower(5000, 1, false);
        HpTowerEnemy.setText(Integer.toString(tEnemy.getHp()));
        
        
        // Game - Jalan
        ActionListener actJalan = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lblRanger.size(); i++) {
                    int posx = lblRanger.get(i).getLocation().x;
                    int posy = lblRanger.get(i).getLocation().y;
                    if (lblRanger.get(i).getIcon().equals(erisJalan)){
                        if (posx+200 < 1030){
                            lblRanger.get(i).setLocation(posx+1, posy);
                        }else if (posx+200 == 1030){
                            lblRanger.get(i).setIcon(erisAttack);
                        }
                    }else if (lblRanger.get(i).getIcon().equals(yoimiyaJalan)){
                        if (posx+200 < 1030){
                            lblRanger.get(i).setLocation(posx+1, posy);
                        }else if (posx+200 == 1030){
                            lblRanger.get(i).setIcon(yoimiyaAttack);
                        }
                    }else if (lblRanger.get(i).getIcon().equals(shogunJalan)){
                        if (posx+200 < 1030){
                            lblRanger.get(i).setLocation(posx+1, posy);
                        }else if (posx+200 == 1030){
                            lblRanger.get(i).setIcon(shogunAttack);
                        }
                    }else if (lblRanger.get(i).getIcon().equals(marsJalan)){
                        if (posx+200 < 1030){
                            lblRanger.get(i).setLocation(posx+1, posy);
                        }else if (posx+200 == 1030){
                            lblRanger.get(i).setIcon(marsAttack);
                        }
                    }else if (lblRanger.get(i).getIcon().equals(newcastleJalan)){
                        if (posx+200 < 1030){
                            lblRanger.get(i).setLocation(posx+1, posy);
                        }else if (posx+200 == 1030){
                            lblRanger.get(i).setIcon(newcastleAttack);
                        }
                    }
                    if (posx != 0){
                        koor.set(i, posx);
                    }else{
                        lblRanger.get(i).setLocation(koor.get(i), 310);
                    }
                }
            }
        };
        
        if (tJalan == null){
            tJalan = new Timer(10, actJalan);
            tJalan.start();
        }
        
        ActionListener actAttack = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lblRanger.size(); i++) {
                    int posx = lblRanger.get(i).getLocation().x;
                    int posy = lblRanger.get(i).getLocation().y;
                    if (lblRanger.get(i).getIcon().equals(erisAttack)){
                        int demeg = u.get(idx).getRanger()[0].getDmg();
                        int curHp = tEnemy.getHp() - demeg;
                        tEnemy.setHp(curHp);
                        HpTowerEnemy.setText(Integer.toString(curHp));
                    }else if (lblRanger.get(i).getIcon().equals(yoimiyaAttack)){
                        int demeg = u.get(idx).getRanger()[1].getDmg();
                        int curHp = tEnemy.getHp() - demeg;
                        tEnemy.setHp(curHp);
                        HpTowerEnemy.setText(Integer.toString(curHp));
                    }else if (lblRanger.get(i).getIcon().equals(shogunJalan)){
                        int demeg = u.get(idx).getRanger()[2].getDmg();
                        int curHp = tEnemy.getHp() - demeg;
                        tEnemy.setHp(curHp);
                        HpTowerEnemy.setText(Integer.toString(curHp));
                    }else if (lblRanger.get(i).getIcon().equals(marsJalan)){
                        int demeg = u.get(idx).getRanger()[4].getDmg();
                        int curHp = tEnemy.getHp() - demeg;
                        tEnemy.setHp(curHp);
                        HpTowerEnemy.setText(Integer.toString(curHp));
                    }else if (lblRanger.get(i).getIcon().equals(newcastleJalan)){
                        int demeg = u.get(idx).getRanger()[4].getDmg();
                        int curHp = tEnemy.getHp() - demeg;
                        tEnemy.setHp(curHp);
                        HpTowerEnemy.setText(Integer.toString(curHp));
                    }
                }
            }
        };
        if (tAttack == null){
            tAttack = new Timer(2000, actAttack);
            tAttack.start();
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
        btTowerAtt = new javax.swing.JButton();
        TowerEnemy = new javax.swing.JLabel();
        TowerPlayer = new javax.swing.JLabel();
        BgBattle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rangers Wars");
        setLocation(new java.awt.Point(325, 180));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btTowerAtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tower Attack.png"))); // NOI18N
        btTowerAtt.setBorderPainted(false);
        btTowerAtt.setContentAreaFilled(false);
        getContentPane().add(btTowerAtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, -1, -1));

        TowerEnemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tower Musuh.png"))); // NOI18N
        getContentPane().add(TowerEnemy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 380, -1, -1));

        TowerPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tower Rangers.png"))); // NOI18N
        getContentPane().add(TowerPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

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
            if (ranger[0] instanceof Eris)
                troopJalan = erisJalan;
            else if (ranger[0] instanceof Yoimiya)
                troopJalan = yoimiyaJalan;
            else if (ranger[0] instanceof RaidenShogun)
                troopJalan = shogunJalan;
            else if (ranger[0] instanceof Mars)
                troopJalan = marsJalan;
            else if (ranger[0] instanceof NewCastle)
                troopJalan = newcastleJalan;

            // Setting
            lblRanger.get(lblRanger.size()-1).setIcon(troopJalan);
            lblRanger.get(lblRanger.size()-1).setBounds(210, 310, 200, 270);
            getContentPane().add(lblRanger.get(lblRanger.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1),1);
            koor.add(0);
        }
    }//GEN-LAST:event_Ranger1ActionPerformed

    private void Ranger2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ranger2ActionPerformed
        int cost = ranger[1].getMineral();
        if (curMana > cost){
            curMana -= cost;
            
            lblRanger.add(new JLabel());
            // Cek Icon
            ImageIcon troopJalan = null;
            if (ranger[1] instanceof Eris)
                troopJalan = erisJalan;
            else if (ranger[1] instanceof Yoimiya)
                troopJalan = yoimiyaJalan;
            else if (ranger[1] instanceof RaidenShogun)
                troopJalan = shogunJalan;
            else if (ranger[1] instanceof Mars)
                troopJalan = marsJalan;
            else if (ranger[1] instanceof NewCastle)
                troopJalan = newcastleJalan;

            // Setting
            lblRanger.get(lblRanger.size()-1).setIcon(troopJalan);
            lblRanger.get(lblRanger.size()-1).setBounds(210, 310, 200, 270);
            getContentPane().add(lblRanger.get(lblRanger.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1),1);
            koor.add(0);
        }
    }//GEN-LAST:event_Ranger2ActionPerformed

    private void Ranger3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ranger3ActionPerformed
        int cost = ranger[2].getMineral();
        if (curMana > cost){
            curMana -= cost;
            
            lblRanger.add(new JLabel());
            // Cek Icon
            ImageIcon troopJalan = null;
            if (ranger[2] instanceof Eris)
                troopJalan = erisJalan;
            else if (ranger[2] instanceof Yoimiya)
                troopJalan = yoimiyaJalan;
            else if (ranger[2] instanceof RaidenShogun)
                troopJalan = shogunJalan;
            else if (ranger[2] instanceof Mars)
                troopJalan = marsJalan;
            else if (ranger[2] instanceof NewCastle)
                troopJalan = newcastleJalan;

            // Setting
            lblRanger.get(lblRanger.size()-1).setIcon(troopJalan);
            lblRanger.get(lblRanger.size()-1).setBounds(210, 310, 200, 270);
            getContentPane().add(lblRanger.get(lblRanger.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1),1);
            koor.add(0);
        }
    }//GEN-LAST:event_Ranger3ActionPerformed

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
    private javax.swing.JLabel CurMineral;
    private javax.swing.JLabel HPTEnemyBorder;
    private javax.swing.JLabel HPTRangerBorder;
    private javax.swing.JLabel HpTowerEnemy;
    private javax.swing.JLabel HpTowerRanger;
    private javax.swing.JLabel MaxMineral;
    private javax.swing.JLabel R1Cost;
    private javax.swing.JLabel R2Cost;
    private javax.swing.JLabel R3Cost;
    private javax.swing.JButton Ranger1;
    private javax.swing.JButton Ranger2;
    private javax.swing.JButton Ranger3;
    private javax.swing.JLabel TowerEnemy;
    private javax.swing.JLabel TowerPlayer;
    private javax.swing.JButton btPause;
    private javax.swing.JButton btTowerAtt;
    // End of variables declaration//GEN-END:variables
}
