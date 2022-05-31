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
public class Eris extends Ranger implements Serializable{
    
    public Eris(String nama, int level) {
        super(nama, level, 620, 55, 1, 10, 20,
                new ImageIcon("src\\images\\Eris kecil utk blok.png"),
                new ImageIcon("src\\images\\ErisJalan.gif"),
                new ImageIcon("src\\images\\Eris_Attack.gif"));
    }
    
}
