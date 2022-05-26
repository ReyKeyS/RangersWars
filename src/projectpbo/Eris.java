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
public class Eris extends Ranger implements Serializable{
    // Nama      : "Eris";
    // HP        : 500
    // DMG       : 50
    // Range     : Deket (sesuaino)
    // Movement  : -
    // Mineral   : -
    
    public Eris(String nama, int hp, int dmg, int range, int movement, int mineral) {
        super(nama, hp, dmg, range, movement, mineral);
    }
    
}
