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

    private int[][] palikanMatriisi;

    public Palikka() { //tässä vaiheessa kokeilussa **** muotoinen palikka
        palikanMatriisi = new int[1][4];
        for (int korkeus = 0; korkeus < palikanMatriisi.length; ++korkeus) {
            for (int leveys = 0; leveys < palikanMatriisi[korkeus].length; ++leveys) {
               palikanMatriisi[korkeus][leveys] = 1; 
            }
        }


    }

    public int[][] haePalikanMatriisi() {
        return palikanMatriisi;
    }
}
