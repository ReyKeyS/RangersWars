/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectpbo;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;

/**
 *
 * @author Grady
 */
public class Leaderboard extends javax.swing.JFrame {
    private Music MainTheme = null;
    private boolean kemute = false;
    private boolean keplay = false;
    
    private ArrayList<User> user;
    /**
     * Creates new form Leaderboard
     */
    public Leaderboard() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public Leaderboard(ArrayList<User> players, Music MainTheme, boolean kemute, boolean keplay) {
        this.MainTheme = MainTheme;
        this.kemute = kemute;
        this.keplay = keplay;
        
        this.user = players;
        Collections.sort(user, new SortLeader());
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon bg = new ImageIcon("src\\images\\Background Leaderboard.gif");
        BgLeader.setIcon(bg);
        nomor1.setText("-----");
        nomor2.setText("-----");
        nomor3.setText("-----");
        
        if (user.size() > 0){
            if (user.get(0) != null){
                nomor1.setText(user.get(0).getNama() + " - " + user.get(0).getLevel());
            }
            if (user.size() > 1){
                if (user.get(1) != null){
                    nomor2.setText(user.get(1).getNama() + " - " + user.get(1).getLevel());
                }
                if (user.size() > 2){
                    if (user.get(2) != null){
                        nomor3.setText(user.get(2).getNama() + " - " + user.get(2).getLevel());
                    }
                }
            }
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

        nomor1 = new javax.swing.JLabel();
        nomor2 = new javax.swing.JLabel();
        nomor3 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        BgLeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomor1.setBackground(new java.awt.Color(255, 255, 51));
        nomor1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nomor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomor1.setText("Player 1");
        nomor1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nomor1.setOpaque(true);
        getContentPane().add(nomor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 225, 230, 40));

        nomor2.setBackground(new java.awt.Color(255, 255, 51));
        nomor2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nomor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomor2.setText("Player 2");
        nomor2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nomor2.setOpaque(true);
        getContentPane().add(nomor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 290, 230, 40));

        nomor3.setBackground(new java.awt.Color(255, 255, 51));
        nomor3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nomor3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomor3.setText("Player 3");
        nomor3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nomor3.setOpaque(true);
        getContentPane().add(nomor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 345, 230, 40));

        Back.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back button.png"))); // NOI18N
        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        Back.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back button hovered.png"))); // NOI18N
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 150, 150));

        BgLeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Leaderboard_page.jpg"))); // NOI18N
        getContentPane().add(BgLeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        dispose();
        new Login(MainTheme, kemute, keplay).setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Leaderboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel BgLeader;
    private javax.swing.JLabel nomor1;
    private javax.swing.JLabel nomor2;
    private javax.swing.JLabel nomor3;
    // End of variables declaration//GEN-END:variables
}
