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
public class Yoimiya extends Ranger implements Serializable{

    public Yoimiya(String nama, int level) {
        super(nama, level, 580, 40, 5, 10, 25,
                new ImageIcon("src\\images\\Yoimiya kecil utk blok.png"),
                new ImageIcon("src\\images\\Yoimiya Jalan Revisi.gif"),
                new ImageIcon("src\\images\\Yoimiya Attack Resize.gif"));
    }

}
