/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import ohtyo.*;

/**
 *
 * @author ronniebr
 */
public class Tetrisikkuna extends JFrame {
    JLabel statusbar;
    Timer timer;
    
    Ruudukko ruudukko = new Ruudukko();
    
    public Tetrisikkuna() {
        statusbar = new JLabel("0");
        add(statusbar, BorderLayout.SOUTH);
        setFocusable(true);
        ruudukko.uusiPalikka();
        
        
        
        

        
    }
    
}
