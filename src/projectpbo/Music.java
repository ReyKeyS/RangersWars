/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author RyanK
 */
public class Music {
    static Music player = new Music();
    
    static Clip clip;

    public Music() {
    }
    
    public static Music getInstance(){
        return player;
    }
    
    public static void loadMusic(){
        try{
            File musicPath = new File("bgmusic.wav");
            AudioInputStream audioinput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioinput);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Music Error");
        }
    }
    
}
