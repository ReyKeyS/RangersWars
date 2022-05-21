/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

import java.util.Comparator;

/**
 *
 * @author RyanK
 */
public class SortLeader implements Comparator<User>{

    @Override
    public int compare(User u1, User u2) {
        if (u1.getLevel() > u2.getLevel()) return -1;
        else if (u1.getLevel() == u2.getLevel()) return 0;
        else return 1;
    }
    
}
