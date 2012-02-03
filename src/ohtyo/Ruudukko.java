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
     * Luo oletuskokoisen ruudukon 11*24 ja asettaa ruudukon "reunojen" arvoksi 9
     */
    public Ruudukko() {

        ruudukonMatriisi = new int[13][24];
        for (int i = 0; i < ruudukonMatriisi.length; i++) {


            ruudukonMatriisi[i][0] = 9;

        }
        for (int i = 0; i < 24; i++) {
            ruudukonMatriisi[12][i] = 9;
            ruudukonMatriisi[0][i] = 9;
        }

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
     * @return true/false
     */
    public boolean ruutuTyhja(int x, int y) {
        if (ruudukonMatriisi[x][y] == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tarkistaa ensin, että kaikkia palikan paloja voi siirtää haluttuun
     * suuntaan, jos ei niin palauttaa false Jos voidaan siirtää, niin
     * siirretään kutsumalla palikan omaa siirtometodia. Siirron jälkeen
     * tarkistetaan vielä jos palikkaa voi siirtää uudestaan johonkin suuntaan.
     * Jos siirron jälkeen ei enää voida siirtää niin pistetään palikan paikka
     * muistiin ja luodaan uusi palikka ruudukkoon. Siirtää palikkaa ruudukossa
     * haluttuun suuntaan
     *
     * @param suunta vasen, oikea, alas
     * @param palikka aktiivinen palikka
     * @return true jos siirto onnistui, false jos ei voi siirtää
     */
    public boolean siirraPalikka(char suunta) {
        if (suunta == 'v') {
            for (int i = 0; i < palikka.getPalat().length; i++) {
                if (ruutuTyhja(palikka.getPalat()[i].getxkoordinaatti() - 1,
                        palikka.getPalat()[i].getykoordinaatti()) == false) {
                    return false;
                }
            }
            palikka.siirra(suunta);
            if (voikoSiirtaaPalikkaa() == false) {
                for (int i = 0; i < palikka.getPalat().length; i++) {
                    ruudukonMatriisi[palikka.getPalat()[i].getxkoordinaatti()][
                        palikka.getPalat()[i].getykoordinaatti()] = 1;
                }
                uusiPalikka();
            }

            return true;


        } else if (suunta == 'o') {
            for (int i = 0; i < palikka.getPalat().length; i++) {
                if (ruutuTyhja(palikka.getPalat()[i].getxkoordinaatti() + 1,
                        palikka.getPalat()[i].getykoordinaatti()) == false) {

                    return false;
                }
            }
            palikka.siirra(suunta);
            if (voikoSiirtaaPalikkaa() == false) {
                for (int i = 0; i < palikka.getPalat().length; i++) {
                    ruudukonMatriisi[palikka.getPalat()[i].getxkoordinaatti()][
                        palikka.getPalat()[i].getykoordinaatti()] = 1;
                }
                uusiPalikka();
            }

            return true;

        } else if (suunta == 'a') {
            for (int i = 0; i < palikka.getPalat().length; i++) {
                if (ruutuTyhja(palikka.getPalat()[i].getxkoordinaatti(),
                        palikka.getPalat()[i].getykoordinaatti() - 1) == false) {
                    return false;
                }

            }
            palikka.siirra(suunta);
            if (voikoSiirtaaPalikkaa() == false) {
                for (int i = 0; i < palikka.getPalat().length; i++) {
                    ruudukonMatriisi[palikka.getPalat()[i].getxkoordinaatti()][
                        palikka.getPalat()[i].getykoordinaatti()] = 1;
                }
                uusiPalikka();
            }


            return true;


        } else {
            return false;
        }
    }

    /**
     * Tarkistetaan voiko palikkaa siirtää mihinkään suuntaan.
     *
     * @param palikka aktiivinen palikka
     * @return true jos palikkaa voi siirtää johonkin, false jos ei voi
     */
    public boolean voikoSiirtaaPalikkaa() {
        for (int i = 0; i < palikka.getPalat().length; i++) {
            if (ruutuTyhja(palikka.getPalat()[1].getxkoordinaatti(),
                    palikka.getPalat()[i].getykoordinaatti() - 1) == false
                    /*&& ruutuTyhja(palikka.getPalat()[i].getxkoordinaatti() + 1,
                    palikka.getPalat()[i].getykoordinaatti()) == false
                    && ruutuTyhja(palikka.getPalat()[i].getxkoordinaatti() - 1,
                    palikka.getPalat()[i].getykoordinaatti()) == false
                    */ ) {
                return false;
            }
        }

        return true;

    }

    /**
     * palauttaa viitteen palikkaan joka juuri sillä hetkellä on aktiivisena
     *
     * @return
     */
    public Palikka kahvaAktiiviseenPalikkaan() {
        return palikka;
    }

    /**
     * Poistaa rivin ruudukosta, eli muuttaa rivin arvot matriisissa nolliksi
     *
     * @param y poistettavan rivin y-axelin koordinaatti
     */
    public void poistaRivi(int y) {
        for (int i = 0; i < ruudukonMatriisi.length; i++) {
            ruudukonMatriisi[i][y] = 0;
        }

    }

    /**
     * Palauttaa arvonaan ruudukon matriisin pituuden
     *
     * @return matriisin pituus
     */
    public int ruudukonKoko() {
        return ruudukonMatriisi.length;
    }
    public int[][] getRuudukonMatriisi(){
        return ruudukonMatriisi;
    }
}
