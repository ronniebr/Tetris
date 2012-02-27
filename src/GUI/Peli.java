/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import tetrisLogiikka.Ruudukko;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 *
 * @author ronniebr
 */
public class Peli extends JPanel implements KeyListener {

    Ruudukko ruudukko = new Ruudukko();
    int aika = 800;
    Ajastin ajastin = new Ajastin(this, aika);
    boolean peliAloitettu, peliPause = false;

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.drawString("Pisteet: " + ruudukko.getPisteet(), 10, 30);
        g.drawString("S = START", 10, 50);
        g.drawString("U = UUSI PELI", 100, 50);
        g.drawString("P = PAUSE", 10, 70);
        g.drawString("Ohjaa palikkaa nuolinäppäimillä", 10, 90);
        for (int i = 0, x = 10; i < ruudukko.getRuudukonMatriisi().length; i++, x = x + 20) {
            for (int j = 0, y = 510; j < ruudukko.getRuudukonMatriisi()[i].length - 4; j++, y = y - 20) {

                if (ruudukko.getRuudukonMatriisi()[i][j] == 9) {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(x, y, 20, 20);

                } else if (ruudukko.getRuudukonMatriisi()[i][j] == 1) {
                    if (ruudukko.kahvaAktiiviseenPalikkaan().getTyyppi() == 1) {
                        g.setColor(Color.BLUE);
                        g.fillRect(x, y, 20, 20);
                    } else if (ruudukko.kahvaAktiiviseenPalikkaan().getTyyppi() == 2) {
                        g.setColor(Color.CYAN);
                        g.fillRect(x, y, 20, 20);
                    } else if (ruudukko.kahvaAktiiviseenPalikkaan().getTyyppi() == 3) {
                        g.setColor(Color.MAGENTA);
                        g.fillRect(x, y, 20, 20);
                    } else if (ruudukko.kahvaAktiiviseenPalikkaan().getTyyppi() == 4) {
                        g.setColor(Color.YELLOW);
                        g.fillRect(x, y, 20, 20);
                    } else if (ruudukko.kahvaAktiiviseenPalikkaan().getTyyppi() == 5) {
                        g.setColor(Color.PINK);
                        g.fillRect(x, y, 20, 20);
                    }

                } else if (ruudukko.getRuudukonMatriisi()[i][j] == 2) {
                    if (ruudukko.kahvaAktiiviseenPalikkaan().getTyyppi() == 1) {
                        g.setColor(Color.RED);
                        g.fillRect(x, y, 20, 20);
                    } else if (ruudukko.kahvaAktiiviseenPalikkaan().getTyyppi() == 2) {
                        g.setColor(Color.ORANGE);
                        g.fillRect(x, y, 20, 20);
                    } else if (ruudukko.kahvaAktiiviseenPalikkaan().getTyyppi() == 3) {
                        g.setColor(Color.GREEN);
                        g.fillRect(x, y, 20, 20);
                    } else if (ruudukko.kahvaAktiiviseenPalikkaan().getTyyppi() == 4) {
                        g.setColor(Color.ORANGE);
                        g.fillRect(x, y, 20, 20);
                    } else if (ruudukko.kahvaAktiiviseenPalikkaan().getTyyppi() == 5) {
                        g.setColor(Color.YELLOW);
                        g.fillRect(x, y, 20, 20);
                    }


                }
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x, y, 20, 20);
            }
        }
        if (ruudukko.onkoPeliLoppu() == true) {
            g.setColor(Color.RED);

            g.drawString("Game over!", 230, 50);



        }
        if (peliPause) {
            g.setColor(Color.RED);

            g.drawString("Paused", 230, 50);



        }




    }

    public void aikaOnKulunut() {
        ruudukko.siirraPalikka('a');


        repaint();
    }

    public void keyPressed(KeyEvent e) {


        if (e.getKeyCode() == KeyEvent.VK_S) {
            if (peliAloitettu == false) {
                ruudukko.uusiPalikka();
                ajastin.start();
                repaint();
                peliAloitettu = true;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            if (peliPause == false) {
                ajastin.stop();
                peliPause = true;
                repaint();


            } else {
                ajastin.start();
                peliPause = false;
                repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_U) {
            ruudukko = new Ruudukko();

            aika = 800;
            ajastin = new Ajastin(this, aika);
            peliAloitettu = peliPause = false;
            repaint();


        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (peliPause == false) {
                ruudukko.siirraPalikka('a');
                repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (peliPause == false) {
                ruudukko.siirraPalikka('v');
                repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (peliPause == false) {
                ruudukko.siirraPalikka('o');
                repaint();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (peliPause == false) {
                ruudukko.kaannaPalikkaa();
                repaint();
            }

        }

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
