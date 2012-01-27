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

    public PalikanPala(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int xkoordinaatti() {
        return x;
    }

    public int ykoordinaatti() {
        return y;
    }

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

    public boolean osuukoJohonkin(Ruudukko ruudukko) {
        if (ruudukko.ruutuTyhja(x, y)) {
            return false;
        } else {
            return true;
        }
    }
}
