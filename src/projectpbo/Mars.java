/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

import java.io.Serializable;

/**
 *
 * @author RyanK
 */
public class Mars extends Ranger implements Serializable{

    public Mars(String nama, int hp, int dmg, int range, int movement, int mineral) {
        super(nama, hp, dmg, range, movement, mineral);
    }
    
}