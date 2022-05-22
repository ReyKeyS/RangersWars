/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectpbo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author RyanK
 */
public class Login extends javax.swing.JFrame {
    private ArrayList<User> user;
    
    static boolean keplay = false;
    static Music player = Music.getInstance();
    
    /**
     * Creates new form Login
     */
        
    public Login() {
        initComponents();
        this.user = new ArrayList<>();
        // Load
        try {
            FileInputStream load = new FileInputStream(System.getProperty("user.dir") + "\\users.ser");
            ObjectInputStream in = new ObjectInputStream(load);
            this.user = (ArrayList<User>) in.readObject();
            in.close();
            load.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "failed");
        }
        if (!keplay){
            keplay = true;
            player.loadMusic();
            player.clip.setMicrosecondPosition(17800000);
            player.clip.start();
            player.clip.loop(Clip.LOOP_CONTINUOUSLY);
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

        Username = new javax.swing.JLabel();
        Judul = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        btPlay = new javax.swing.JButton();
        btLeader = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rangers Wars");
        setLocation(new java.awt.Point(325, 180));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Username.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Username.setText("Name : ");
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 70, -1));

        Judul.setFont(new java.awt.Font("Maiandra GD", 1, 72)); // NOI18N
        Judul.setText("Rangers Wars");
        getContentPane().add(Judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 100, -1, 90));

        tfNama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(tfNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 330, 40));

        btPlay.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btPlay.setText("Play");
        btPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 230, 60));

        btLeader.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btLeader.setText("Leaderboard");
        btLeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLeaderActionPerformed(evt);
            }
        });
        getContentPane().add(btLeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, 320, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlayActionPerformed
        String curNama = tfNama.getText();
        int idxLog = -1;
        boolean found = false;
        if (!curNama.equals("")){
            for (int i = 0; i < user.size(); i++) {
                if (user.get(i).getNama().equals(curNama)){
                    idxLog = i;
                    found = true;
                }
            }
            if (found){
                dispose();
                new Game(user, idxLog).setVisible(true);
            }else{
                dispose();
                user.add(new User(curNama));
                new Game(user, user.size()-1).setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Wajib Input Nama");
        }
    }//GEN-LAST:event_btPlayActionPerformed

    private void btLeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLeaderActionPerformed
        // TODO add your handling code here:
        dispose();
        new Leaderboard(user).setVisible(true);
    }//GEN-LAST:event_btLeaderActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Judul;
    private javax.swing.JLabel Username;
    private javax.swing.JButton btLeader;
    private javax.swing.JButton btPlay;
    private javax.swing.JTextField tfNama;
    // End of variables declaration//GEN-END:variables
}
