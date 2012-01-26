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

    public Palikka(int tyyppi) { //tässä vaiheessa kokeilussa **** muotoinen palikka
        if (tyyppi == 1) 
        palikanTyyppi = new int[1][4];
        for (int korkeus = 0; korkeus < palikanTyyppi.length; ++korkeus) {
            for (int leveys = 0; leveys < palikanTyyppi[korkeus].length; ++leveys) {
               palikanTyyppi[korkeus][leveys] = 1; 
            }
        }


    }

    public int[][] haePalikanTyyppi() {
        return palikanTyyppi;
    }
    public boolean siirra(char suunta) {
        if (suunta == 'v' ) {
            palikanKoordinaatit [1]--;
            return true;
            }
        else if (suunta == 'o') {
            palikanKoordinaatit[1]++;
            return true;
            
        }
        else if (suunta == 'a') {
            palikanKoordinaatit[0]--;
            return true;
        }
        return false;
    }
}
