/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtyo;

/**
 *
 * @author ronniebr
 */
public class PalikanPala {

    private int x, y;
    /**
     * Konstruktori luo yhden palan tetrispalikalle ja asettaa sille x- ja y-koordinaatin
     * 
     * @param x koordinaatti    
     * @param y koordinaatti
     */

    public PalikanPala(int x, int y) {
        this.x = x;
        this.y = y;

    }
/**
 * Metodi palauttaa arvonaan x-koordinaatin arvon
 * @return x koordinaatti
 */
    public int xkoordinaatti() {
        return x;
    }
 /**
 * Metodi palauttaa arvonaan y-koordinaatin arvon
 * @return y koordinaatti
 */

    public int ykoordinaatti() {
        return y;
    }
    /**
     * Metodi siirtää palaa haluttuun suuntaan tietyssä ruudukossa jos suunnassa oleva
     * ruutu on tyhjä ja palauttaa arvonaan true. Jos ruutu, johon siirretään on varattu
     * ei tee mitään ja palauttaa false
     * 
     * @param suunta siirron haluttu suunta(oikea, vasen, alas)
     * @param ruudukko ruudukko jossa siirto tehdään
     * @return 
     */

    public boolean siirra(char suunta, Ruudukko ruudukko) {
        if (suunta == 'v') {
            if (ruudukko.ruutuTyhja(x - 1, y)) {
                x--;
                return true;
            } else {
                return false;
            }
        } else if (suunta == 'o') {
            if (ruudukko.ruutuTyhja(x + 1, y)) {
                x++;
                return true;
            } else {
                return false;
            }

        } else if (suunta == 'a') {
            if (ruudukko.ruutuTyhja(x, y - 1)) {
                y--;
                return true;
            } else {
                return false;
            }


        } else {
            return false;
        }
    }
/**
 * Toistaiseksi turha metodi, koska siirrettäessä jo tarkistetaan että siirretään vain 
 * tyhjiin ruutuihin
 * @param ruudukko
 * @return 
 */
    public boolean osuukoJohonkin(Ruudukko ruudukko) {
        if (ruudukko.ruutuTyhja(x, y)) {
            return false;
        } else {
            return true;
        }
    }
}
