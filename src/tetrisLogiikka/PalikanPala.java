/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisLogiikka;

/**
 *
 * @author ronniebr
 */
public class PalikanPala {

    private int x, y;

    /**
     * Konstruktori luo yhden palan tetrispalikalle ja asettaa sille x- ja
     * y-koordinaatin
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
     *
     * @return x koordinaatti
     */
    public int getxkoordinaatti() {
        return x;
    }

    /**
     * Metodi palauttaa arvonaan y-koordinaatin arvon
     *
     * @return y koordinaatti
     */
    public int getykoordinaatti() {
        return y;
    }

    /**
     * Metodi asettaa uuden x-koordinaatin arvon
     *
     * @param x
     */
    public void setxkoordinaatti(int x) {
        this.x = x;

    }

    /**
     * Metodi asettaa uuden y-koordinaatin arvon
     *
     * @param y
     */
    public void setykoordinaatti(int y) {
        this.y = y;
    }

    /**
     * Metodi siirtää palaa haluttuun suuntaan
     *
     * @param suunta siirron haluttu suunta(oikea, vasen, alas)
     *
     */
    public void siirra(char suunta) {
        if (suunta == 'v') {

            x--;

        } else if (suunta == 'o') {

            x++;


        } else if (suunta == 'a') {

            y--;



        }
    }
}
