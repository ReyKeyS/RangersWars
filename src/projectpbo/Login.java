/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectpbo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author RyanK
 */
public class Login extends javax.swing.JFrame {
    private ArrayList<User> user;
    
    private boolean keplay = false;
    private boolean kemute = false;
    private Music MainTheme = null;
    private Music btClick = new Music("src\\music\\buttonclick.wav");
    
    /**
     * Creates new form Login
     */
    
    public Login(){
        initComponents();
        this.setLocationRelativeTo(null);
        this.user = new ArrayList<>();
        // Load
        try {
            FileInputStream load = new FileInputStream(System.getProperty("user.dir") + "\\users.ser");
            ObjectInputStream in = new ObjectInputStream(load);
            this.user = (ArrayList<User>) in.readObject();
            in.close();
            load.close();
        } catch (Exception ex) {
            
        }
        if (!keplay){
            keplay = true;
            MainTheme = new Music("src/music/bg.wav");
            MainTheme.Clip().setMicrosecondPosition(0);
            MainTheme.Clip().start();
            MainTheme.Clip().loop(Clip.LOOP_CONTINUOUSLY);
        }
        if (!kemute){
            btMute.setIcon(new ImageIcon("src\\images\\Music button.png"));
            btMute.setRolloverIcon(new ImageIcon("src\\images\\Music button hovered.png"));
        }else{
            btMute.setIcon(new ImageIcon("src\\images\\Music button muted.png"));
            btMute.setRolloverIcon(new ImageIcon("src\\images\\Music button hovered mutted.png"));
        }
    }
    
    public Login(Music MainTheme, boolean kemute, boolean keplay) {
        this.MainTheme = MainTheme;
        this.kemute = kemute;
        this.keplay = keplay;
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.user = new ArrayList<>();
        // Load
        try {
            FileInputStream load = new FileInputStream(System.getProperty("user.dir") + "\\users.ser");
            ObjectInputStream in = new ObjectInputStream(load);
            this.user = (ArrayList<User>) in.readObject();
            in.close();
            load.close();
        } catch (Exception ex) {
            
        }
        if (!keplay){
            keplay = true;
            MainTheme = new Music("src/music/bg.wav");
            MainTheme.Clip().setMicrosecondPosition(0);
            MainTheme.Clip().start();
            MainTheme.Clip().loop(Clip.LOOP_CONTINUOUSLY);
        }
        if (!kemute){
            btMute.setIcon(new ImageIcon("src\\images\\Music button.png"));
            btMute.setRolloverIcon(new ImageIcon("src\\images\\Music button hovered.png"));
        }else{
            btMute.setIcon(new ImageIcon("src\\images\\Music button muted.png"));
            btMute.setRolloverIcon(new ImageIcon("src\\images\\Music button hovered mutted.png"));
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

        btPlay = new javax.swing.JButton();
        tfNama = new javax.swing.JTextField();
        btLeader = new javax.swing.JButton();
        btMute = new javax.swing.JButton();
        BgLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rangers Wars");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btPlay.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol Play.png"))); // NOI18N
        btPlay.setBorderPainted(false);
        btPlay.setContentAreaFilled(false);
        btPlay.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol Play hovered.png"))); // NOI18N
        btPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 424, 120, 120));

        tfNama.setFont(new java.awt.Font("Segoe UI", 0, 38)); // NOI18N
        tfNama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNama.setBorder(null);
        getContentPane().add(tfNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 338, 460, 60));

        btLeader.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btLeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Leaderboard button.png"))); // NOI18N
        btLeader.setBorderPainted(false);
        btLeader.setContentAreaFilled(false);
        btLeader.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Leaderboard button hovered.png"))); // NOI18N
        btLeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLeaderActionPerformed(evt);
            }
        });
        getContentPane().add(btLeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 424, 120, 120));

        btMute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Music button.png"))); // NOI18N
        btMute.setBorderPainted(false);
        btMute.setContentAreaFilled(false);
        btMute.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Music button hovered.png"))); // NOI18N
        btMute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMuteActionPerformed(evt);
            }
        });
        getContentPane().add(btMute, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 424, 120, 120));

        BgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Halaman login.jpg"))); // NOI18N
        getContentPane().add(BgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
                if (!kemute){
                    btClick = new Music("src\\music\\buttonclick.wav");
                    btClick.Clip().start();
                }
                JOptionPane.showMessageDialog(null, "Berhasil Login!", "Message", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new Game(user, idxLog, MainTheme, kemute, keplay).setVisible(true);
            }else{
                if (!kemute){
                    btClick = new Music("src\\music\\buttonclick.wav");
                    btClick.Clip().start();
                }
                int confirm = JOptionPane.showConfirmDialog(null, "Yakin Membuat Akun Baru?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == 0){
                    dispose();
                    user.add(new User(curNama));
                    new Game(user, user.size()-1, MainTheme, kemute, keplay).setVisible(true);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Wajib Input Nama","Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btPlayActionPerformed

    private void btLeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLeaderActionPerformed
        // TODO add your handling code here:
        dispose();
        new Leaderboard(user, MainTheme, kemute, keplay).setVisible(true);
        if (!kemute){
            btClick = new Music("src\\music\\buttonclick.wav");
            btClick.Clip().start();
        }
    }//GEN-LAST:event_btLeaderActionPerformed

    private void btMuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMuteActionPerformed
        FloatControl volume = (FloatControl) MainTheme.Clip().getControl(FloatControl.Type.MASTER_GAIN);
        if(!kemute){
            volume.setValue(-80f);
            kemute = true;
            ImageIcon img = new ImageIcon("src\\images\\Music button muted.png");
            ImageIcon imghover = new ImageIcon("src\\images\\Music button hovered mutted.png");
            btMute.setIcon(img);
            btMute.setRolloverIcon(imghover);
        }else{
            volume.setValue(-10f);
            kemute = false;
            ImageIcon img = new ImageIcon("src\\images\\Music button.png");
            ImageIcon imghover = new ImageIcon("src\\images\\Music button hovered.png");
            btMute.setIcon(img);
            btMute.setRolloverIcon(imghover);
        }
    }//GEN-LAST:event_btMuteActionPerformed

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
    private javax.swing.JLabel BgLogin;
    private javax.swing.JButton btLeader;
    private javax.swing.JButton btMute;
    private javax.swing.JButton btPlay;
    private javax.swing.JTextField tfNama;
    // End of variables declaration//GEN-END:variables
}
