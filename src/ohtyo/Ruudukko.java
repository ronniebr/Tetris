/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtyo;

/**
 *
 * @author ronniebr
 */
public class Ruudukko {
   private int korkeus, leveys;
   private int[][] ruudukonMatriisi;


    public Ruudukko() {

        ruudukonMatriisi = new int[20][11];
        
    }
    public Ruudukko(int korkeus, int leveys) {
        ruudukonMatriisi = new int[korkeus][leveys];
        
        
    }
    public void uusiPalikkaRuudukkoon(Palikka palikka){
        int[][] palikanTyyppi = palikka.haePalikanMatriisi();
        int apumuuttuja = 5; //koska palikka syntyy keskelle ruudukkoa
        for (int rivi = 0;rivi < palikanTyyppi.length; ++rivi) {
            for (int sarake = 0; sarake < palikanTyyppi[korkeus].length; ++sarake) {
               if (palikanTyyppi[rivi][sarake] == 1){
                   ruudukonMatriisi[0][apumuuttuja] = 1;
               apumuuttuja++;
               }
                   


        
        
            }
    }
    }
    public boolean ruutuTyhja(int x, int y) {
        if (ruudukonMatriisi [x][y] == 0)
            return true;
        else
            return false;
    }
    

}
