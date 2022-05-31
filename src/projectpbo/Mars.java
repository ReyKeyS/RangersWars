/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author RyanK
 */
public class Mars extends Ranger implements Serializable{

    public Mars(String nama, int level) {
        super(nama, level, 740, 63, 1, 10, 20,
                new ImageIcon("src\\images\\Yoimiya kecil utk blok.png"),
                new ImageIcon("src\\images\\Yoimiya Jalan Revisi.gif"),
                new ImageIcon("src\\images\\Yoimiya Attack Resize.gif"));
    }
    
}
