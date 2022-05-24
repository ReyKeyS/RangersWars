/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectpbo;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


/**
 *
 * @author RyanK
 */
public class Game extends javax.swing.JFrame {
    
    private ArrayList<User> user = new ArrayList<>();
    private int idx;
    
    /**
     * Creates new form Game
     */
    public Game(ArrayList<User> player, int idx) {
        initComponents();
        this.idx = idx;
        this.user = player;
        judul.setText(user.get(idx).getNama());
        Level.setText(""+user.get(idx).getLevel());
        Gold.setText("" + user.get(idx).getGold());
    }
    
    public Game(){
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btUpgrade = new javax.swing.JButton();
        IdleEris = new javax.swing.JLabel();
        IdleYoimiya = new javax.swing.JLabel();
        btLogout = new javax.swing.JButton();
        judul = new javax.swing.JLabel();
        btLaunch = new javax.swing.JButton();
        GoldLB = new javax.swing.JLabel();
        LevelLB = new javax.swing.JLabel();
        Level = new javax.swing.JLabel();
        Gold = new javax.swing.JLabel();
        WelcomeLB = new javax.swing.JLabel();
        HeroStand = new javax.swing.JLabel();
        BgGame = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rangers Wars");
        setLocation(new java.awt.Point(325, 180));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btUpgrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol upgrade.png"))); // NOI18N
        btUpgrade.setBorderPainted(false);
        btUpgrade.setContentAreaFilled(false);
        btUpgrade.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol upgrade Hovered.png"))); // NOI18N
        getContentPane().add(btUpgrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, 140, 140));

        IdleEris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Eris Jalan.gif"))); // NOI18N
        getContentPane().add(IdleEris, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, 290));

        IdleYoimiya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Yoimiya Jalan.gif"))); // NOI18N
        getContentPane().add(IdleYoimiya, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        btLogout.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exit button.png"))); // NOI18N
        btLogout.setBorderPainted(false);
        btLogout.setContentAreaFilled(false);
        btLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btLogout.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exit button hovered.png"))); // NOI18N
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 140, 140));

        judul.setBackground(new java.awt.Color(0, 0, 0));
        judul.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        judul.setForeground(new java.awt.Color(255, 255, 255));
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setOpaque(true);
        getContentPane().add(judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, 220, 40));

        btLaunch.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btLaunch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol Start.png"))); // NOI18N
        btLaunch.setBorderPainted(false);
        btLaunch.setContentAreaFilled(false);
        btLaunch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btLaunch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol Start Hovered.png"))); // NOI18N
        btLaunch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLaunchActionPerformed(evt);
            }
        });
        getContentPane().add(btLaunch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 530, 190, 180));

        GoldLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GoldLB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gold  _ label.png"))); // NOI18N
        getContentPane().add(GoldLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        LevelLB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Level _ label.png"))); // NOI18N
        getContentPane().add(LevelLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        Level.setBackground(new java.awt.Color(0, 0, 0));
        Level.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 52)); // NOI18N
        Level.setForeground(new java.awt.Color(0, 102, 255));
        Level.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Level.setText("Level");
        Level.setToolTipText("");
        Level.setOpaque(true);
        getContentPane().add(Level, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 25, 170, 50));

        Gold.setBackground(new java.awt.Color(0, 0, 0));
        Gold.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 52)); // NOI18N
        Gold.setForeground(new java.awt.Color(255, 255, 0));
        Gold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Gold.setText("Gold");
        Gold.setOpaque(true);
        getContentPane().add(Gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 86, 170, 50));

        WelcomeLB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Welcome_label.png"))); // NOI18N
        getContentPane().add(WelcomeLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        HeroStand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bawahe Rangers.png"))); // NOI18N
        getContentPane().add(HeroStand, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        BgGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Background Habis login revisi.gif"))); // NOI18N
        getContentPane().add(BgGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
        // Saving
        try {            
            FileOutputStream save = new FileOutputStream(System.getProperty("user.dir") + "\\users.ser");
            ObjectOutputStream out = new ObjectOutputStream(save);
            out.writeObject(this.user);
            out.close();
            save.close();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "failed");
        }
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btLogoutActionPerformed

    private void btLaunchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLaunchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLaunchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BgGame;
    private javax.swing.JLabel Gold;
    private javax.swing.JLabel GoldLB;
    private javax.swing.JLabel HeroStand;
    private javax.swing.JLabel IdleEris;
    private javax.swing.JLabel IdleYoimiya;
    private javax.swing.JLabel Level;
    private javax.swing.JLabel LevelLB;
    private javax.swing.JLabel WelcomeLB;
    private javax.swing.JButton btLaunch;
    private javax.swing.JButton btLogout;
    private javax.swing.JButton btUpgrade;
    private javax.swing.JLabel judul;
    // End of variables declaration//GEN-END:variables
}
