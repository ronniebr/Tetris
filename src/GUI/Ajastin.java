/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Ajastin extends Timer implements ActionListener {

    private Peli peli;
    private int kiihdytin;

    public Ajastin(Peli peli, int aika) {
        super(aika, null);
        this.peli = peli;
        this.addActionListener(this);
        this.setRepeats(true);
    }

    public void actionPerformed(ActionEvent e) {

        peli.aikaOnKulunut();
    }
}