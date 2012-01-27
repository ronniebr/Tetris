/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtyo;

/**
 *
 * @author ronniebr
 */
public class Palikka {
    /*
     * Palikka koostuu neljästä ruudusta
     *
     */

    private int[][] palikanTyyppi;
    private int[] palikanKoordinaatit = new int[] {21,5};
    private PalikanPala pala1,pala2,pala3,pala4;

    public Palikka(int tyyppi) { //tässä vaiheessa kokeilussa **** muotoinen palikka
        if (tyyppi == 1) {
            pala1 = new PalikanPala(5,21);
            pala2 = new PalikanPala(5,22);
            pala3 = new PalikanPala(5,23);
            pala4 = new PalikanPala (5,24);
            
        }
        /* if (tyyppi == 1) 
        palikanTyyppi = new int[1][4];
        for (int korkeus = 0; korkeus < palikanTyyppi.length; ++korkeus) {
            for (int leveys = 0; leveys < palikanTyyppi[korkeus].length; ++leveys) {
               palikanTyyppi[korkeus][leveys] = 1; 
            }
        }
        * 
        */


    }

    public int[][] haePalikanTyyppi() {
        return palikanTyyppi;
    }
    public boolean siirra(char suunta, Ruudukko ruudukko) {
        if (suunta == 'v' ) {
            pala1.siirra('v', ruudukko);
            pala2.siirra('v', ruudukko);
            pala3.siirra('v', ruudukko);
            pala4.siirra('v', ruudukko);
            return true;
            }
        else if (suunta == 'o') {
            pala1.siirra('o', ruudukko);
            pala2.siirra('o', ruudukko);
            pala3.siirra('o', ruudukko);
            pala4.siirra('o', ruudukko);
            return true;
            
        }
        else if (suunta == 'a') {
            pala1.siirra('a', ruudukko);
            pala2.siirra('a', ruudukko);
            pala3.siirra('a', ruudukko);
            pala4.siirra('a', ruudukko);
            return true;
        }
        return false;
    }
}
