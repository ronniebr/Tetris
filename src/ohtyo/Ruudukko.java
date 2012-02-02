/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtyo;

import java.math.*;

/**
 *
 * @author ronniebr
 */
public class Ruudukko {

    private int korkeus, leveys;
    private int[][] ruudukonMatriisi;
    private Palikka palikka;

    /**
     * Luo oletuskokoisen ruudukon 11*24
     */
    public Ruudukko() {

        ruudukonMatriisi = new int[11][24];

    }

    /**
     * Luo halutun kokoisen ruudukon
     *
     * @param korkeus ruudukon korkeus
     * @param leveys ruudukon leveys
     */
    public Ruudukko(int korkeus, int leveys) {
        ruudukonMatriisi = new int[leveys][korkeus];


    }

    /**
     * Luo uuden satunnaisen tyyppisen tetrispalikan ruudukkoon
     *
     */
    public void uusiPalikka() {

        palikka = new Palikka((int) (5 * Math.random()) + 1);


    }

    /**
     * Tarkistaa, että tietty ruutu ruudukossa on tyhjä ja palauttaa totuusarvon
     *
     * @param x koordinaatti
     * @param y kooordinaatti
     * @return tre/false
     */
    public boolean ruutuTyhja(int x, int y) {
        if (ruudukonMatriisi[x][y] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean siirraPalikka(char suunta, Palikka palikka) {
        if (suunta == 'v') {
            for (int i = 0; i < palikka.getPalat().length; i++) {
                if (ruutuTyhja(palikka.getPalat()[i].getxkoordinaatti() - 1,
                        palikka.getPalat()[i].getykoordinaatti()) == false) {
                    return false;
                }
            }
            palikka.siirra(suunta);
            return true;


        } else if (suunta == 'o') {
            for (int i = 0; i < palikka.getPalat().length; i++) {
                if (ruutuTyhja(palikka.getPalat()[1].getxkoordinaatti() + 1,
                        palikka.getPalat()[1].getykoordinaatti()) == false) {

                    return false;
                }
            }
            palikka.siirra(suunta);
            return true;

        } else if (suunta == 'a') {
            for (int i = 0; i < palikka.getPalat().length; i++) {
                if (ruutuTyhja(palikka.getPalat()[1].getxkoordinaatti(),
                        palikka.getPalat()[1].getykoordinaatti() - 1) == false) {
                    return false;
                }

            }
            palikka.siirra(suunta);
            return true;


        } else {
            return false;
        }
    }

    /**
     * palauttaa viitteen palikkaan joka juuri sillä hetkellä on aktiivisena
     *
     * @return
     */
    public Palikka kahvaAktiiviseenPalikkaan() {
        return palikka;
    }

    public int ruudukonKoko() {
        return ruudukonMatriisi.length;
    }
}
