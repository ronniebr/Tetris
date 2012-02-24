/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.*;

import javax.swing.*;


import ohtyo.*;

/**
 *
 * @author ronniebr
 */
public class Tetrisikkuna extends JFrame {
    JLabel statusbar;
    Timer timer;
    
// luodaan ikkuna
   public static void main(String[] args) {
JFrame dlg = new JFrame();


// luodaan piirturi
Piirturi piirturi = new Piirturi();

// otetaan viite ikkunan containeriin ja asetetaan piirturi siihen
Container container = dlg.getContentPane();

container.add(piirturi);

// ikkunan koko, sulkemistoiminnallisuus ja näkyväksi asetus
dlg.setSize(360, 750);
dlg.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
dlg.setVisible(true);
}
}