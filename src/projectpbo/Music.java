/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

/**
 *
 * @author RyanK
 */
public class Music {
    private Clip clip;

    public Music(String filepath) {
        try{
            File musicPath = new File(filepath);
            AudioInputStream audioinput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioinput);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-10f);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Music Error");
        }
    }

    public Clip Clip() {
        return clip;
    }

}
