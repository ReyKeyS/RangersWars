/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectpbo;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RyanK
 */
public class TowerUp extends javax.swing.JFrame {
    private Music MainTheme = null;
    private boolean kemute = false;
    private boolean keplay = false;
    
    private ArrayList<User> pemain = new ArrayList<>();
    private int idx;
    
    private int curGold;
    private int lvlHp;
    private int lvlRate;
    private int lvlMax;
    private int hargaHp;
    private int hargaRate;
    private int hargaMax;
    
    /**
     * Creates new form TowerUp
     */
    public TowerUp() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public TowerUp(ArrayList<User> player, int idx, Music MainTheme, boolean kemute, boolean keplay) {
        this.MainTheme = MainTheme;
        this.kemute = kemute;
        this.keplay = keplay;
        
        this.pemain = player;
        this.idx = idx;
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        // Gold
        this.curGold = pemain.get(idx).getGold();
        gold.setText(Integer.toString(curGold));
        // Details        
        TowerHp.setText(Integer.toString(pemain.get(idx).getTower().getHp()));
        TowerRate.setText(Integer.toString(pemain.get(idx).getTower().getMineralRate()));
        TowerMax.setText(Integer.toString(pemain.get(idx).getTower().getMineralMax()));
        // Levels
        this.lvlHp = pemain.get(idx).getTower().getLevelHp();
        this.lvlRate = pemain.get(idx).getTower().getLevelRate();
        this.lvlMax = pemain.get(idx).getTower().getLevelMax();
        LevelHp.setText("Level " + Integer.toString(lvlHp));
        LevelRate.setText("Level " + Integer.toString(lvlRate));
        LevelMax.setText("Level " + Integer.toString(lvlMax));
        // Cost
        this.hargaHp = 10 * lvlHp;
        this.hargaRate = 10 * lvlRate;
        this.hargaMax = 10 * lvlMax;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btBack = new javax.swing.JButton();
        gold = new javax.swing.JLabel();
        upRate = new javax.swing.JButton();
        TowerRate = new javax.swing.JLabel();
        costRate = new javax.swing.JLabel();
        LevelRate = new javax.swing.JLabel();
        upMax = new javax.swing.JButton();
        TowerMax = new javax.swing.JLabel();
        costMax = new javax.swing.JLabel();
        LevelMax = new javax.swing.JLabel();
        upHp = new javax.swing.JButton();
        TowerHp = new javax.swing.JLabel();
        costHp = new javax.swing.JLabel();
        LevelHp = new javax.swing.JLabel();
        bgUpTower = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol Back.png"))); // NOI18N
        btBack.setBorderPainted(false);
        btBack.setContentAreaFilled(false);
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });
        getContentPane().add(btBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 29, -1, -1));

        gold.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gold.setText("99999");
        getContentPane().add(gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(1151, 32, 98, -1));

        upRate.setText("upRate");
        upRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upRateActionPerformed(evt);
            }
        });
        getContentPane().add(upRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 550, 100, 80));

        TowerRate.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TowerRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TowerRate.setText("99999");
        getContentPane().add(TowerRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 630, 110, -1));

        costRate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        costRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costRate.setText("10");
        getContentPane().add(costRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 570, 60, -1));

        LevelRate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 64)); // NOI18N
        LevelRate.setForeground(new java.awt.Color(255, 255, 255));
        LevelRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LevelRate.setText("999");
        getContentPane().add(LevelRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 220, 70));

        upMax.setText("upMax");
        upMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upMaxActionPerformed(evt);
            }
        });
        getContentPane().add(upMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 340, 100, 90));

        TowerMax.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TowerMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TowerMax.setText("99999");
        getContentPane().add(TowerMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 110, -1));

        costMax.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        costMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costMax.setText("10");
        getContentPane().add(costMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 360, 60, -1));

        LevelMax.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 64)); // NOI18N
        LevelMax.setForeground(new java.awt.Color(255, 255, 255));
        LevelMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LevelMax.setText("999");
        getContentPane().add(LevelMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 220, 70));

        upHp.setText("upHp");
        upHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upHpActionPerformed(evt);
            }
        });
        getContentPane().add(upHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 140, 110, 80));

        TowerHp.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TowerHp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TowerHp.setText("99999");
        getContentPane().add(TowerHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 110, -1));

        costHp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        costHp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costHp.setText("10");
        getContentPane().add(costHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, 60, -1));

        LevelHp.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 64)); // NOI18N
        LevelHp.setForeground(new java.awt.Color(255, 255, 255));
        LevelHp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LevelHp.setText("999");
        getContentPane().add(LevelHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 220, 70));

        bgUpTower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Tower.jpg"))); // NOI18N
        getContentPane().add(bgUpTower, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        try {            
            FileOutputStream save = new FileOutputStream(System.getProperty("user.dir") + "\\users.ser");
            ObjectOutputStream out = new ObjectOutputStream(save);
            out.writeObject(this.pemain);
            out.close();
            save.close();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "failed");
        }
        dispose();
        new Game(pemain, idx, MainTheme, kemute, keplay).setVisible(true);
    }//GEN-LAST:event_btBackActionPerformed

    private void upHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upHpActionPerformed
        if (curGold >= hargaHp){
            // SetGold
            curGold -= hargaHp;
            hargaHp += 10;
            pemain.get(idx).setGold(curGold);
            gold.setText(Integer.toString(curGold));
            // LevelUp
            lvlHp++;
            pemain.get(idx).getTower().setLevelHp(lvlHp);
            pemain.get(idx).getTower().setHp(pemain.get(idx).getTower().getHp() + 100);
            // Update Screen
            TowerHp.setText(Integer.toString(pemain.get(idx).getTower().getHp()));
            LevelHp.setText("Level " + Integer.toString(lvlHp));
        }
    }//GEN-LAST:event_upHpActionPerformed

    private void upRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upRateActionPerformed
        if (curGold >= hargaRate){
            // SetGold
            curGold -= hargaRate;
            hargaRate += 10;
            pemain.get(idx).setGold(curGold);
            gold.setText(Integer.toString(curGold));
            // LevelUp
            lvlRate++;
            pemain.get(idx).getTower().setLevelRate(lvlRate);
            pemain.get(idx).getTower().setMineralRate(pemain.get(idx).getTower().getMineralRate() + 100);
            // Update Screen
            TowerRate.setText(Integer.toString(pemain.get(idx).getTower().getMineralRate()));
            LevelRate.setText("Level " + Integer.toString(lvlRate));
        }
    }//GEN-LAST:event_upRateActionPerformed

    private void upMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upMaxActionPerformed
        
    }//GEN-LAST:event_upMaxActionPerformed

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
            java.util.logging.Logger.getLogger(TowerUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TowerUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TowerUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TowerUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TowerUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LevelHp;
    private javax.swing.JLabel LevelMax;
    private javax.swing.JLabel LevelRate;
    private javax.swing.JLabel TowerHp;
    private javax.swing.JLabel TowerMax;
    private javax.swing.JLabel TowerRate;
    private javax.swing.JLabel bgUpTower;
    private javax.swing.JButton btBack;
    private javax.swing.JLabel costHp;
    private javax.swing.JLabel costMax;
    private javax.swing.JLabel costRate;
    private javax.swing.JLabel gold;
    private javax.swing.JButton upHp;
    private javax.swing.JButton upMax;
    private javax.swing.JButton upRate;
    // End of variables declaration//GEN-END:variables
}
