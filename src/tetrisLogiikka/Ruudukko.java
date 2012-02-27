/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisLogiikka;

import java.math.*;

/**
 *
 * @author ronniebr
 */
public class Ruudukko {

    private int korkeus, leveys;
    private int[][] ruudukonMatriisi;
    private Palikka palikka;
    private int pisteet = 0;
    private boolean peliLoppu = false;

    /**
     * Luo oletuskokoisen ruudukon 12*25 ja asettaa ruudukon "reunojen" arvoksi
     * 9
     */
    public Ruudukko() {

        ruudukonMatriisi = new int[12][25];
        for (int i = 0; i < ruudukonMatriisi.length; i++) {


            ruudukonMatriisi[i][0] = 9;

        }
        for (int i = 0; i < 25; i++) {
            ruudukonMatriisi[11][i] = 9;
            ruudukonMatriisi[0][i] = 9;
        }

    }

    /**
     * Luo uuden satunnaisen tyyppisen tetrispalikan ruudukkoon ja asettaa
     * ruudukon arvoksi 2, palikan nykyiselle sijainnille.
     */
    public void uusiPalikka() {
        int tyyppi = (int) (5 * Math.random()) + 1;

        palikka = new Palikka(tyyppi);

        paivitaRuudukonArvoja(2);

    }

    /**
     * Tarkistaa, että tietty ruutu ruudukossa on tyhjä ja palauttaa totuusarvon
     * Ruutu on tyhjä jos se on arvoltaan 0 tai 2 (2 esittää palikan nykyistä
     * sijaintia)
     *
     * @param x koordinaatti
     * @param y kooordinaatti
     * @return true/false
     */
    public boolean ruutuTyhja(int x, int y) {
        if (ruudukonMatriisi[x][y] == 0 || ruudukonMatriisi[x][y] == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tarkistaa ensin, että kaikkia palikan paloja voi siirtää haluttuun
     * suuntaan. Jos voidaan siirtää, niin siirretään kutsumalla palikan omaa
     * siirtometodia. Ennen ja jälkeen siirron, muistetaan myös päivittää
     * palikan nykyistä sijaintia ruudukossa. Siirron jälkeen tarkistetaan vielä
     * jos palikkaa voi siirtää alaspäin. Jos siirron jälkeen ei enää voida
     * siirtää alaspäin, niin pistetään palikan paikka muistiin, ja luodaan uusi
     * palikka ruudukkoon. Pysähtyneet palikat merkitään ruudukossa arvolla 1
     *
     * Alaspäin suunnatun siirron jälkeen tarkistetaan myös, jos siirto on
     * täyttänyt jonkun rivin. Täydet rivit poistetaan. Tämän lisäksi
     * tarkistetaan myös jos palikka on maximikorkeudessa 21. Jos on, niin ei
     * enää luoda uusia palikoita ja peli päättyy.
     *
     * @param suunta vasen, oikea, alas.
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
            paivitaRuudukonArvoja(0);
            palikka.siirra(suunta);
            paivitaRuudukonArvoja(2);
            if (voikoVielaSiirtaaPalikkaa() == false) {
                paivitaRuudukonArvoja(1);
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
            paivitaRuudukonArvoja(0);
            palikka.siirra(suunta);
            paivitaRuudukonArvoja(2);

            if (voikoVielaSiirtaaPalikkaa() == false) {
                paivitaRuudukonArvoja(1);
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
            paivitaRuudukonArvoja(0);
            palikka.siirra(suunta);
            paivitaRuudukonArvoja(2);

            if (voikoVielaSiirtaaPalikkaa() == false) {
                paivitaRuudukonArvoja(1);
                for (int i = 0; i < palikka.getPalat().length; i++) {
                    if (onkoRiviTaysi(palikka.getPalat()[i].getykoordinaatti())) {
                        poistaRivi(palikka.getPalat()[i].getykoordinaatti());
                    }
                }

                if (palikkaRajalla()) {
                    peliLoppu = true;
                    return true;
                }
                uusiPalikka();
            }


            return true;


        } else {
            return false;
        }
    }

    /**
     * Kääntää palikkaa 90 astetta oikealle. Kääntöoperaatiot eroavat toisistaan
     * palikan tyypin perusteella, esim. neliölle ei tarvitse tehdä mitään.
     * Muille palikoille tarkistetaan ensin miten päin ne jo on käännetty. Seuraavaksi
     * tarkistetaan, että palikkaa voidaan kääntää, eli ettei mitään ole edessä.
     * Lopuksi käännetään muuttamalla palikan palojen koordinaatteja (keskimmäinen
     * palikanpala pysyy aina paikallaan, ja loput kiertävät sen ympärillä).
     */
    public void kaannaPalikkaa() {
        if (palikka.getTyyppi() == 5) {
            return;
        }
        if (palikka.getTyyppi() == 1) {
            if (palikka.getPalat()[1].getxkoordinaatti()
                    == palikka.getPalat()[2].getxkoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() - 1,
                        palikka.getPalat()[0].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() + 1,
                        palikka.getPalat()[2].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti() + 2,
                        palikka.getPalat()[3].getykoordinaatti() - 2) == false) {
                    return;
                }
                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() - 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() + 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() + 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() - 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() + 2);
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() - 2);
                paivitaRuudukonArvoja(2);


            } else if (palikka.getPalat()[1].getxkoordinaatti()
                    != palikka.getPalat()[2].getxkoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() + 1,
                        palikka.getPalat()[0].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() - 1,
                        palikka.getPalat()[2].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti() - 2,
                        palikka.getPalat()[3].getykoordinaatti() + 2) == false) {
                    return;
                }
                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() + 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() - 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() - 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() + 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() - 2);
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() + 2);
                paivitaRuudukonArvoja(2);


            }

        }
        if (palikka.getTyyppi() == 3) {
            if (palikka.getPalat()[1].getxkoordinaatti()
                    == palikka.getPalat()[2].getxkoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() + 1,
                        palikka.getPalat()[0].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() + 1,
                        palikka.getPalat()[2].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti(),
                        palikka.getPalat()[3].getykoordinaatti() - 2) == false) {
                    return;
                }
                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() + 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() + 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() + 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() - 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() );
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() - 2);
                paivitaRuudukonArvoja(2);


            } else if (palikka.getPalat()[1].getxkoordinaatti()
                    != palikka.getPalat()[2].getxkoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() - 1,
                        palikka.getPalat()[0].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() - 1,
                        palikka.getPalat()[2].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti() ,
                        palikka.getPalat()[3].getykoordinaatti() + 2) == false) {
                    return;
                }
                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() - 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() - 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() - 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() + 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() );
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() + 2);
                paivitaRuudukonArvoja(2);


            }

        }
        if (palikka.getTyyppi() == 2) {
            if (palikka.getPalat()[1].getxkoordinaatti()
                    > palikka.getPalat()[0].getxkoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() + 1,
                        palikka.getPalat()[0].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() + 1,
                        palikka.getPalat()[2].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti() + 2,
                        palikka.getPalat()[3].getykoordinaatti() - 2) == false) {
                    return;
                }

                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() + 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() + 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() + 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() - 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() + 2);
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() - 2);
                paivitaRuudukonArvoja(2);
            } else if (palikka.getPalat()[1].getxkoordinaatti() == palikka.getPalat()[0].getxkoordinaatti()
                    && palikka.getPalat()[1].getykoordinaatti() < palikka.getPalat()[0].getykoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() + 1,
                        palikka.getPalat()[0].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() - 1,
                        palikka.getPalat()[2].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti() - 2,
                        palikka.getPalat()[3].getykoordinaatti() - 2) == false) {
                    return;
                }
                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() + 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() - 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() - 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() - 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() - 2);
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() - 2);
                paivitaRuudukonArvoja(2);
            } else if (palikka.getPalat()[1].getxkoordinaatti() < palikka.getPalat()[0].getxkoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() - 1,
                        palikka.getPalat()[0].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() - 1,
                        palikka.getPalat()[2].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti() - 2,
                        palikka.getPalat()[3].getykoordinaatti() + 2) == false) {
                    return;
                }
                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() - 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() - 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() - 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() + 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() - 2);
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() + 2);
                paivitaRuudukonArvoja(2);
            } else if (palikka.getPalat()[1].getxkoordinaatti() == palikka.getPalat()[0].getxkoordinaatti()
                    && palikka.getPalat()[1].getykoordinaatti() > palikka.getPalat()[0].getykoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() - 1,
                        palikka.getPalat()[0].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() + 1,
                        palikka.getPalat()[2].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti() + 2,
                        palikka.getPalat()[3].getykoordinaatti() + 2) == false) {
                    return;
                }
                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() - 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() + 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() + 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() + 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() + 2);
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() + 2);
                paivitaRuudukonArvoja(2);
            }

        }

        if (palikka.getTyyppi() == 4) {
            if (palikka.getPalat()[1].getxkoordinaatti()
                    < palikka.getPalat()[0].getxkoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() - 1,
                        palikka.getPalat()[0].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() + 1,
                        palikka.getPalat()[2].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti() + 2,
                        palikka.getPalat()[3].getykoordinaatti() - 2) == false) {
                    return;
                }

                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() - 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() - 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() + 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() - 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() + 2);
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() - 2);
                paivitaRuudukonArvoja(2);
            } else if (palikka.getPalat()[1].getxkoordinaatti() == palikka.getPalat()[0].getxkoordinaatti()
                    && palikka.getPalat()[1].getykoordinaatti() > palikka.getPalat()[0].getykoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() - 1,
                        palikka.getPalat()[0].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() - 1,
                        palikka.getPalat()[2].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti() - 2,
                        palikka.getPalat()[3].getykoordinaatti() - 2) == false) {
                    return;
                }
                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() - 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() + 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() - 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() - 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() - 2);
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() - 2);
                paivitaRuudukonArvoja(2);
            } else if (palikka.getPalat()[1].getxkoordinaatti() > palikka.getPalat()[0].getxkoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() + 1,
                        palikka.getPalat()[0].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() - 1,
                        palikka.getPalat()[2].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti() - 2,
                        palikka.getPalat()[3].getykoordinaatti() + 2) == false) {
                    return;
                }
                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() + 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() + 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() - 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() + 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() - 2);
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() + 2);
                paivitaRuudukonArvoja(2);
            } else if (palikka.getPalat()[1].getxkoordinaatti() == palikka.getPalat()[0].getxkoordinaatti()
                    && palikka.getPalat()[1].getykoordinaatti() < palikka.getPalat()[0].getykoordinaatti()) {
                if (ruutuTyhja(palikka.getPalat()[0].getxkoordinaatti() + 1,
                        palikka.getPalat()[0].getykoordinaatti() - 1) == false
                        || ruutuTyhja(palikka.getPalat()[2].getxkoordinaatti() + 1,
                        palikka.getPalat()[2].getykoordinaatti() + 1) == false
                        || ruutuTyhja(palikka.getPalat()[3].getxkoordinaatti() + 2,
                        palikka.getPalat()[3].getykoordinaatti() + 2) == false) {
                    return;
                }
                paivitaRuudukonArvoja(0);
                palikka.getPalat()[0].setxkoordinaatti(palikka.getPalat()[0].getxkoordinaatti() + 1);
                palikka.getPalat()[0].setykoordinaatti(palikka.getPalat()[0].getykoordinaatti() - 1);

                palikka.getPalat()[2].setxkoordinaatti(palikka.getPalat()[2].getxkoordinaatti() + 1);
                palikka.getPalat()[2].setykoordinaatti(palikka.getPalat()[2].getykoordinaatti() + 1);

                palikka.getPalat()[3].setxkoordinaatti(palikka.getPalat()[3].getxkoordinaatti() + 2);
                palikka.getPalat()[3].setykoordinaatti(palikka.getPalat()[3].getykoordinaatti() + 2);
                paivitaRuudukonArvoja(2);
            }

        }



    }

    /**
     * Tarkistaa onko palikka maximikorkeudessa, eli rajalla. Jos on, niin
     * palauttaa totuusarvon true, jos ei niin false.
     *
     * @return true tai false
     */
    public boolean palikkaRajalla() {
        for (int i = 0; i < ruudukonMatriisi.length; i++) {
            if (ruudukonMatriisi[i][20] == 1) {
                return true;
            }
        }
        return false;

    }

    /**
     * Tarkistetaan voiko palikkaa siirtää alaspäin .
     *
     *
     * @return true jos palikkaa voi siirtää alaspäin, false jos ei voi
     */
    public boolean voikoVielaSiirtaaPalikkaa() {
        for (int i = 0; i < palikka.getPalat().length; i++) {
            if (ruutuTyhja(palikka.getPalat()[i].getxkoordinaatti(),
                    palikka.getPalat()[i].getykoordinaatti() - 1) == false) {
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
     * Poistaa rivin ruudukosta, eli muuttaa rivin arvot matriisissa nolliksi ja
     * lisää pisteitä.
     *
     * @param y poistettavan rivin y-axelin koordinaatti
     */
    public void poistaRivi(int y) {

        int[][] apuMatriisi = new int[12][25];

        for (int i = 1; i < ruudukonMatriisi.length - 1; i++) {
            for (int j = 1; j < ruudukonMatriisi[i].length - 1; j++) {
                apuMatriisi[i][j] = ruudukonMatriisi[i][j + 1];

            }


        }
        for (int i = 0; i < apuMatriisi.length; i++) {


            apuMatriisi[i][0] = 9;

        }
        for (int i = 0; i < 25; i++) {
            apuMatriisi[11][i] = 9;
            apuMatriisi[0][i] = 9;
        }

        ruudukonMatriisi = apuMatriisi;
        pisteet++;


    }

    /**
     * Tarkistaa jos annettu rivi on täysi
     *
     * @param y tarkistettavan rivin y-koordinaatti
     * @return true tai false
     */
    public boolean onkoRiviTaysi(int y) {
        for (int i = 1; i < ruudukonMatriisi.length - 1; i++) {
            if (ruudukonMatriisi[i][y] != 1) {
                return false;
            }

        }
        return true;
    }

    /**
     * Päivittää ruudukon matriisin arvoja, aktiivisen palikan koordinaattien
     * perusteella.
     *
     * @param arvo joksi palikan sijainti ruudukossa muutetaan (0 = tyhjä,
     * 1=pysähtynyt palikka, 2 = aktiivinen palikka)
     *
     */
    public void paivitaRuudukonArvoja(int arvo) {
        for (int i = 0; i < palikka.getPalat().length; i++) {
            ruudukonMatriisi[palikka.getPalat()[i].getxkoordinaatti()][
                        palikka.getPalat()[i].getykoordinaatti()] = arvo;

        }
    }

    public int getRuudukonKoko() {
        return ruudukonMatriisi.length;
    }

    public int[][] getRuudukonMatriisi() {
        return ruudukonMatriisi;
    }

    public int getPisteet() {
        return pisteet;
    }

    public boolean onkoPeliLoppu() {
        if (peliLoppu) {
            return true;
        } else {
            return false;
        }
    }
}
