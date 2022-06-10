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
 * @author Grady
 */
public class Upgrade extends javax.swing.JFrame {
    private Music player = null;
    private boolean kemute = false;
    private boolean keplay = false;
    
    private ArrayList<User> pemain = new ArrayList<>();
    private int idx;
    
    private int curGold;
    private int costEris;
    private int costYoimiya;
    private int costShogun;
    private int costMars;
    private int costNewcastle;
    /**
     * Creates new form Upgrade
     */
    public Upgrade() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public Upgrade(ArrayList<User> pemain,int idx, Music player, boolean kemute, boolean keplay) {
        this.player = player;
        this.kemute = kemute;
        this.keplay = keplay;
        
        this.pemain=pemain;
        this.idx=idx;
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.curGold = pemain.get(idx).getGold();
        gold.setText(Integer.toString(curGold));
        
        hpEris.setText(Integer.toString(pemain.get(idx).getRanger()[0].getHp()));
        dmgEris.setText(Integer.toString(pemain.get(idx).getRanger()[0].getDmg()));
        mineralEris.setText(Integer.toString(pemain.get(idx).getRanger()[0].getMineral()));
        int levelEris = pemain.get(idx).getRanger()[0].getLevel();
        lvlEris.setText("Level " + Integer.toString(levelEris));
        costEris = 5 + (levelEris-1)*10;
        hargaEris.setText(Integer.toString(costEris));
                
        hpYoimiya.setText(Integer.toString(pemain.get(idx).getRanger()[1].getHp()));
        dmgYoimiya.setText(Integer.toString(pemain.get(idx).getRanger()[1].getDmg()));
        mineralYoimiya.setText(Integer.toString(pemain.get(idx).getRanger()[1].getMineral()));
        int levelYoimiya = pemain.get(idx).getRanger()[1].getLevel();
        lvlYoimiya.setText("Level " + Integer.toString(levelYoimiya));
        costYoimiya = 5 + (levelYoimiya-1)*10;
        hargaYoimiya.setText(Integer.toString(costYoimiya));
        
        hpShogun.setText(Integer.toString(pemain.get(idx).getRanger()[2].getHp()));
        dmgShogun.setText(Integer.toString(pemain.get(idx).getRanger()[2].getDmg()));
        mineralShogun.setText(Integer.toString(pemain.get(idx).getRanger()[2].getMineral()));
        int levelShogun = pemain.get(idx).getRanger()[2].getLevel();
        lvlShogun.setText("Level " + Integer.toString(levelShogun));
        costShogun = 5 + (levelShogun-1)*10;
        hargaShogun.setText(Integer.toString(costShogun));
        
        hpMars.setText(Integer.toString(pemain.get(idx).getRanger()[3].getHp()));
        dmgMars.setText(Integer.toString(pemain.get(idx).getRanger()[3].getDmg()));
        mineralMars.setText(Integer.toString(pemain.get(idx).getRanger()[3].getMineral()));
        int levelMars = pemain.get(idx).getRanger()[3].getLevel();
        lvlMars.setText("Level " + Integer.toString(levelMars));
        costMars = 5 + (levelMars-1)*10;
        hargaMars.setText(Integer.toString(costMars));
        
        hpNewcastle.setText(Integer.toString(pemain.get(idx).getRanger()[4].getHp()));
        dmgNewcastle.setText(Integer.toString(pemain.get(idx).getRanger()[4].getDmg()));
        mineralNewcastle.setText(Integer.toString(pemain.get(idx).getRanger()[4].getMineral()));
        int levelNewcastle = pemain.get(idx).getRanger()[4].getLevel();
        lvlNewcastle.setText("Level " + Integer.toString(levelNewcastle));
        costNewcastle = 5 + (levelNewcastle-1)*10;
        hargaNewcastle.setText(Integer.toString(costNewcastle));
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hargaNewcastle = new javax.swing.JLabel();
        lvlNewcastle = new javax.swing.JLabel();
        upNewcastle = new javax.swing.JButton();
        mineralNewcastle = new javax.swing.JLabel();
        dmgNewcastle = new javax.swing.JLabel();
        hpNewcastle = new javax.swing.JLabel();
        hargaMars = new javax.swing.JLabel();
        lvlMars = new javax.swing.JLabel();
        upMars = new javax.swing.JButton();
        mineralMars = new javax.swing.JLabel();
        dmgMars = new javax.swing.JLabel();
        hpMars = new javax.swing.JLabel();
        hargaShogun = new javax.swing.JLabel();
        lvlShogun = new javax.swing.JLabel();
        upShogun = new javax.swing.JButton();
        mineralShogun = new javax.swing.JLabel();
        dmgShogun = new javax.swing.JLabel();
        hpShogun = new javax.swing.JLabel();
        hargaYoimiya = new javax.swing.JLabel();
        lvlYoimiya = new javax.swing.JLabel();
        upYoimiya = new javax.swing.JButton();
        mineralYoimiya = new javax.swing.JLabel();
        dmgYoimiya = new javax.swing.JLabel();
        hpYoimiya = new javax.swing.JLabel();
        hargaEris = new javax.swing.JLabel();
        lvlEris = new javax.swing.JLabel();
        upEris = new javax.swing.JButton();
        mineralEris = new javax.swing.JLabel();
        dmgEris = new javax.swing.JLabel();
        hpEris = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        gold = new javax.swing.JLabel();
        BgUpgrade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rangers Wars");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hargaNewcastle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        hargaNewcastle.setForeground(new java.awt.Color(255, 255, 0));
        hargaNewcastle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hargaNewcastle.setText("99999");
        hargaNewcastle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hargaNewcastle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1092, 640, 110, -1));

        lvlNewcastle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lvlNewcastle.setForeground(new java.awt.Color(255, 255, 255));
        lvlNewcastle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lvlNewcastle.setText("Level 999");
        lvlNewcastle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lvlNewcastle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1091, 575, 110, -1));

        upNewcastle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol up.png"))); // NOI18N
        upNewcastle.setBorderPainted(false);
        upNewcastle.setContentAreaFilled(false);
        upNewcastle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upNewcastleActionPerformed(evt);
            }
        });
        getContentPane().add(upNewcastle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 560, -1, -1));

        mineralNewcastle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        mineralNewcastle.setForeground(new java.awt.Color(255, 255, 255));
        mineralNewcastle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mineralNewcastle.setText("999");
        mineralNewcastle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(mineralNewcastle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 510, 90, -1));

        dmgNewcastle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        dmgNewcastle.setForeground(new java.awt.Color(255, 255, 255));
        dmgNewcastle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dmgNewcastle.setText("999");
        dmgNewcastle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(dmgNewcastle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 455, 90, -1));

        hpNewcastle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        hpNewcastle.setForeground(new java.awt.Color(255, 255, 255));
        hpNewcastle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hpNewcastle.setText("999");
        hpNewcastle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hpNewcastle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 400, 90, -1));

        hargaMars.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        hargaMars.setForeground(new java.awt.Color(255, 255, 0));
        hargaMars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hargaMars.setText("99999");
        hargaMars.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hargaMars, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 640, 110, -1));

        lvlMars.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lvlMars.setForeground(new java.awt.Color(255, 255, 255));
        lvlMars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lvlMars.setText("Level 999");
        lvlMars.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lvlMars, new org.netbeans.lib.awtextra.AbsoluteConstraints(851, 575, 110, -1));

        upMars.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol up.png"))); // NOI18N
        upMars.setBorderPainted(false);
        upMars.setContentAreaFilled(false);
        upMars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upMarsActionPerformed(evt);
            }
        });
        getContentPane().add(upMars, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 560, -1, -1));

        mineralMars.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        mineralMars.setForeground(new java.awt.Color(255, 255, 255));
        mineralMars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mineralMars.setText("999");
        mineralMars.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(mineralMars, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 510, 90, -1));

        dmgMars.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        dmgMars.setForeground(new java.awt.Color(255, 255, 255));
        dmgMars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dmgMars.setText("999");
        dmgMars.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(dmgMars, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 455, 90, -1));

        hpMars.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        hpMars.setForeground(new java.awt.Color(255, 255, 255));
        hpMars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hpMars.setText("999");
        hpMars.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hpMars, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 400, 90, -1));

        hargaShogun.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        hargaShogun.setForeground(new java.awt.Color(255, 255, 0));
        hargaShogun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hargaShogun.setText("99999");
        hargaShogun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hargaShogun, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 645, 110, -1));

        lvlShogun.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lvlShogun.setForeground(new java.awt.Color(255, 255, 255));
        lvlShogun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lvlShogun.setText("Level 999");
        lvlShogun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lvlShogun, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 575, 110, -1));

        upShogun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol up.png"))); // NOI18N
        upShogun.setBorderPainted(false);
        upShogun.setContentAreaFilled(false);
        upShogun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upShogunActionPerformed(evt);
            }
        });
        getContentPane().add(upShogun, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 560, -1, -1));

        mineralShogun.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        mineralShogun.setForeground(new java.awt.Color(255, 255, 255));
        mineralShogun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mineralShogun.setText("999");
        mineralShogun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(mineralShogun, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 90, -1));

        dmgShogun.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        dmgShogun.setForeground(new java.awt.Color(255, 255, 255));
        dmgShogun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dmgShogun.setText("999");
        dmgShogun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(dmgShogun, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 455, 90, -1));

        hpShogun.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        hpShogun.setForeground(new java.awt.Color(255, 255, 255));
        hpShogun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hpShogun.setText("999");
        hpShogun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hpShogun, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 90, -1));

        hargaYoimiya.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        hargaYoimiya.setForeground(new java.awt.Color(255, 255, 0));
        hargaYoimiya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hargaYoimiya.setText("99999");
        hargaYoimiya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hargaYoimiya, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 645, 110, -1));

        lvlYoimiya.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lvlYoimiya.setForeground(new java.awt.Color(255, 255, 255));
        lvlYoimiya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lvlYoimiya.setText("Level 999");
        lvlYoimiya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lvlYoimiya, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 575, 110, -1));

        upYoimiya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol up.png"))); // NOI18N
        upYoimiya.setBorderPainted(false);
        upYoimiya.setContentAreaFilled(false);
        upYoimiya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upYoimiyaActionPerformed(evt);
            }
        });
        getContentPane().add(upYoimiya, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        mineralYoimiya.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        mineralYoimiya.setForeground(new java.awt.Color(255, 255, 255));
        mineralYoimiya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mineralYoimiya.setText("999");
        mineralYoimiya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(mineralYoimiya, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 90, -1));

        dmgYoimiya.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        dmgYoimiya.setForeground(new java.awt.Color(255, 255, 255));
        dmgYoimiya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dmgYoimiya.setText("999");
        dmgYoimiya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(dmgYoimiya, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 455, 90, -1));

        hpYoimiya.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        hpYoimiya.setForeground(new java.awt.Color(255, 255, 255));
        hpYoimiya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hpYoimiya.setText("999");
        hpYoimiya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hpYoimiya, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 90, -1));

        hargaEris.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        hargaEris.setForeground(new java.awt.Color(255, 255, 0));
        hargaEris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hargaEris.setText("99999");
        hargaEris.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hargaEris, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 645, 110, -1));

        lvlEris.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lvlEris.setForeground(new java.awt.Color(255, 255, 255));
        lvlEris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lvlEris.setText("Level 999");
        lvlEris.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lvlEris, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 575, 110, -1));

        upEris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol up.png"))); // NOI18N
        upEris.setBorderPainted(false);
        upEris.setContentAreaFilled(false);
        upEris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upErisActionPerformed(evt);
            }
        });
        getContentPane().add(upEris, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, -1, -1));

        mineralEris.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        mineralEris.setForeground(new java.awt.Color(255, 255, 255));
        mineralEris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mineralEris.setText("999");
        mineralEris.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(mineralEris, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 90, -1));

        dmgEris.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        dmgEris.setForeground(new java.awt.Color(255, 255, 255));
        dmgEris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dmgEris.setText("999");
        dmgEris.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(dmgEris, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 455, 90, -1));

        hpEris.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        hpEris.setForeground(new java.awt.Color(255, 255, 255));
        hpEris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hpEris.setText("999");
        hpEris.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hpEris, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 90, -1));

        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tombol Back.png"))); // NOI18N
        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        gold.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        gold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gold.setText("99999");
        getContentPane().add(gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(1123, 25, 120, -1));

        BgUpgrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Center BARU.jpg"))); // NOI18N
        getContentPane().add(BgUpgrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
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
        new Game(pemain,idx,player,kemute,keplay).setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void upErisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upErisActionPerformed
        if (curGold >= costEris){
            // Kurangi Gold + Update button
            curGold -= costEris;
            pemain.get(idx).setGold(curGold);
            gold.setText(Integer.toString(curGold));
            int levelEris = pemain.get(idx).getRanger()[0].getLevel() + 1;
            pemain.get(idx).getRanger()[0].setLevel(levelEris);
            lvlEris.setText("Level " + Integer.toString(levelEris));
            costEris = 5 + (levelEris-1)*10;
            hargaEris.setText(Integer.toString(costEris));
            
            // Upgrade Status
            pemain.get(idx).getRanger()[0].setHp(pemain.get(idx).getRanger()[0].getHp() + 15);
            pemain.get(idx).getRanger()[0].setDmg(pemain.get(idx).getRanger()[0].getDmg() + 15);
            pemain.get(idx).getRanger()[0].setMineral(pemain.get(idx).getRanger()[0].getMineral() + 5);
            
            hpEris.setText(Integer.toString(pemain.get(idx).getRanger()[0].getHp()));
            dmgEris.setText(Integer.toString(pemain.get(idx).getRanger()[0].getDmg()));
            mineralEris.setText(Integer.toString(pemain.get(idx).getRanger()[0].getMineral()));
        }
    }//GEN-LAST:event_upErisActionPerformed

    private void upYoimiyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upYoimiyaActionPerformed
        if (curGold >= costYoimiya){
            // Kurangi Gold + Update button
            curGold -= costYoimiya;
            pemain.get(idx).setGold(curGold);
            gold.setText(Integer.toString(curGold));
            int levelYoimiya = pemain.get(idx).getRanger()[1].getLevel() + 1;
            pemain.get(idx).getRanger()[1].setLevel(levelYoimiya);
            lvlYoimiya.setText("Level " + Integer.toString(levelYoimiya));
            costYoimiya = 5 + (levelYoimiya-1)*10;
            hargaYoimiya.setText(Integer.toString(costYoimiya));
            
            // Upgrade Status
            pemain.get(idx).getRanger()[1].setHp(pemain.get(idx).getRanger()[1].getHp() + 5);
            pemain.get(idx).getRanger()[1].setDmg(pemain.get(idx).getRanger()[1].getDmg() + 25);
            pemain.get(idx).getRanger()[1].setMineral(pemain.get(idx).getRanger()[1].getMineral() + 5);
            
            hpYoimiya.setText(Integer.toString(pemain.get(idx).getRanger()[1].getHp()));
            dmgYoimiya.setText(Integer.toString(pemain.get(idx).getRanger()[1].getDmg()));
            mineralYoimiya.setText(Integer.toString(pemain.get(idx).getRanger()[1].getMineral()));
        }
    }//GEN-LAST:event_upYoimiyaActionPerformed

    private void upShogunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upShogunActionPerformed
        if (curGold >= costShogun){
            // Kurangi Gold + Update button
            curGold -= costShogun;
            pemain.get(idx).setGold(curGold);
            gold.setText(Integer.toString(curGold));
            int levelShogun = pemain.get(idx).getRanger()[2].getLevel() + 1;
            pemain.get(idx).getRanger()[2].setLevel(levelShogun);
            lvlShogun.setText("Level " + Integer.toString(levelShogun));
            costShogun = 5 + (levelShogun-1)*10;
            hargaShogun.setText(Integer.toString(costShogun));
            
            // Upgrade Status
            pemain.get(idx).getRanger()[2].setHp(pemain.get(idx).getRanger()[2].getHp() + 10);
            pemain.get(idx).getRanger()[2].setDmg(pemain.get(idx).getRanger()[2].getDmg() + 20);
            pemain.get(idx).getRanger()[2].setMineral(pemain.get(idx).getRanger()[2].getMineral() + 5);
            
            hpShogun.setText(Integer.toString(pemain.get(idx).getRanger()[2].getHp()));
            dmgShogun.setText(Integer.toString(pemain.get(idx).getRanger()[2].getDmg()));
            mineralShogun.setText(Integer.toString(pemain.get(idx).getRanger()[2].getMineral()));
        }
    }//GEN-LAST:event_upShogunActionPerformed

    private void upMarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upMarsActionPerformed
        if (curGold >= costMars){
            // Kurangi Gold + Update button
            curGold -= costMars;
            pemain.get(idx).setGold(curGold);
            gold.setText(Integer.toString(curGold));
            int levelMars = pemain.get(idx).getRanger()[3].getLevel() + 1;
            pemain.get(idx).getRanger()[3].setLevel(levelMars);
            lvlMars.setText("Level " + Integer.toString(levelMars));
            costMars = 5 + (levelMars-1)*10;
            hargaMars.setText(Integer.toString(costMars));
            
            // Upgrade Status
            pemain.get(idx).getRanger()[3].setHp(pemain.get(idx).getRanger()[3].getHp() + 25);
            pemain.get(idx).getRanger()[3].setDmg(pemain.get(idx).getRanger()[3].getDmg() + 5);
            pemain.get(idx).getRanger()[3].setMineral(pemain.get(idx).getRanger()[3].getMineral() + 5);
            
            hpMars.setText(Integer.toString(pemain.get(idx).getRanger()[3].getHp()));
            dmgMars.setText(Integer.toString(pemain.get(idx).getRanger()[3].getDmg()));
            mineralMars.setText(Integer.toString(pemain.get(idx).getRanger()[3].getMineral()));
        }
    }//GEN-LAST:event_upMarsActionPerformed

    private void upNewcastleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upNewcastleActionPerformed
        if (curGold >= costNewcastle){
            // Kurangi Gold + Update button
            curGold -= costNewcastle;
            pemain.get(idx).setGold(curGold);
            gold.setText(Integer.toString(curGold));
            int levelNewcastle = pemain.get(idx).getRanger()[4].getLevel() + 1;
            pemain.get(idx).getRanger()[4].setLevel(levelNewcastle);
            lvlNewcastle.setText("Level " + Integer.toString(levelNewcastle));
            costNewcastle = 5 + (levelNewcastle-1)*10;
            hargaNewcastle.setText(Integer.toString(costNewcastle));
            
            // Upgrade Status
            pemain.get(idx).getRanger()[4].setHp(pemain.get(idx).getRanger()[4].getHp() + 20);
            pemain.get(idx).getRanger()[4].setDmg(pemain.get(idx).getRanger()[4].getDmg() + 10);
            pemain.get(idx).getRanger()[4].setMineral(pemain.get(idx).getRanger()[4].getMineral() + 5);
            
            hpNewcastle.setText(Integer.toString(pemain.get(idx).getRanger()[4].getHp()));
            dmgNewcastle.setText(Integer.toString(pemain.get(idx).getRanger()[4].getDmg()));
            mineralNewcastle.setText(Integer.toString(pemain.get(idx).getRanger()[4].getMineral()));
        }
    }//GEN-LAST:event_upNewcastleActionPerformed

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
            java.util.logging.Logger.getLogger(Upgrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Upgrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Upgrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Upgrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Upgrade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel BgUpgrade;
    private javax.swing.JLabel dmgEris;
    private javax.swing.JLabel dmgMars;
    private javax.swing.JLabel dmgNewcastle;
    private javax.swing.JLabel dmgShogun;
    private javax.swing.JLabel dmgYoimiya;
    private javax.swing.JLabel gold;
    private javax.swing.JLabel hargaEris;
    private javax.swing.JLabel hargaMars;
    private javax.swing.JLabel hargaNewcastle;
    private javax.swing.JLabel hargaShogun;
    private javax.swing.JLabel hargaYoimiya;
    private javax.swing.JLabel hpEris;
    private javax.swing.JLabel hpMars;
    private javax.swing.JLabel hpNewcastle;
    private javax.swing.JLabel hpShogun;
    private javax.swing.JLabel hpYoimiya;
    private javax.swing.JLabel lvlEris;
    private javax.swing.JLabel lvlMars;
    private javax.swing.JLabel lvlNewcastle;
    private javax.swing.JLabel lvlShogun;
    private javax.swing.JLabel lvlYoimiya;
    private javax.swing.JLabel mineralEris;
    private javax.swing.JLabel mineralMars;
    private javax.swing.JLabel mineralNewcastle;
    private javax.swing.JLabel mineralShogun;
    private javax.swing.JLabel mineralYoimiya;
    private javax.swing.JButton upEris;
    private javax.swing.JButton upMars;
    private javax.swing.JButton upNewcastle;
    private javax.swing.JButton upShogun;
    private javax.swing.JButton upYoimiya;
    // End of variables declaration//GEN-END:variables
}
