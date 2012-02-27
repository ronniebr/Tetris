/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.*;

import javax.swing.*;



/**
 *
 * @author ronniebr
 */
public class Tetrisikkuna  {
    
    
    
// luodaan ikkuna
   public static void main(String[] args) {
JFrame ikkuna = new JFrame();
Peli peli = new Peli();

ikkuna.setSize(440, 750);
ikkuna.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
ikkuna.setVisible(true);
ikkuna.addKeyListener(peli);

peli.setBackground(Color.black);
Container sisalto = ikkuna.getContentPane();
sisalto.add(peli);












}
}