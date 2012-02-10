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


    private PalikanPala[] tetrisPalikka = new PalikanPala[4];

    /**
     * Konstruktori luo tietyn tyyppisen tetrispalikan. Tetrispalikka koostuu
     * neljästä palasta. Palojen koordinaatit riippuvat palikan tyypistä.
     *
     * @param tyyppi Haluttu tetrispalikan tyyppi, esim I;Z;L;J;O
     */
    public Palikka(int tyyppi) { 
        if (tyyppi == 1) {//I


            tetrisPalikka[0] = new PalikanPala(5, 21);
            tetrisPalikka[1] = new PalikanPala(5, 22);
            tetrisPalikka[2] = new PalikanPala(5, 23);
            tetrisPalikka[3] = new PalikanPala(5, 24);

        }
        else if (tyyppi == 2){//J
            tetrisPalikka[0] = new PalikanPala(5, 21);
            tetrisPalikka[1] = new PalikanPala(6, 21);
            tetrisPalikka[2] = new PalikanPala(6, 22);
            tetrisPalikka[3] = new PalikanPala(6, 23);
            
        }
        else if (tyyppi == 3) {//Z
            tetrisPalikka[0] = new PalikanPala(5, 21);
            tetrisPalikka[1] = new PalikanPala(6, 21);
            tetrisPalikka[2] = new PalikanPala(6, 22);
            tetrisPalikka[3] = new PalikanPala(7, 22);
            
        }
        else if(tyyppi == 4) {//L
            tetrisPalikka[0] = new PalikanPala(6, 21);
            tetrisPalikka[1] = new PalikanPala(5, 21);
            tetrisPalikka[2] = new PalikanPala(5, 22);
            tetrisPalikka[3] = new PalikanPala(5, 23);
            
        }
        else if(tyyppi == 5) {//O
            tetrisPalikka[0] = new PalikanPala(6, 21);
            tetrisPalikka[1] = new PalikanPala(5, 21);
            tetrisPalikka[2] = new PalikanPala(5, 22);
            tetrisPalikka[3] = new PalikanPala(6, 22);
            
        }
        



    }

    /**
     * metodi siirtää tetrispalikkaa oikealle, vasemalle tai alas . 
     * Kutsuu tetrispalikan neljän palan omia siirra metodeita.
     *
     * @param suunta siirron suunta (vasen, oikea, alas)
     
     
     */
    public void siirra(char suunta) {
        if (suunta == 'v') {
            for (int i = 0; i < tetrisPalikka.length; i++) {
                tetrisPalikka[i].siirra('v');
            }

            
        } else if (suunta == 'o') {
            for (int i = 0; i < tetrisPalikka.length; i++) {
                tetrisPalikka[i].siirra('o');
            }
            

        } else if (suunta == 'a') {
            for (int i = 0; i < tetrisPalikka.length; i++) {
                tetrisPalikka[i].siirra('a');
            }
            
        }
        
    }
  /**
   * Palauttaa arvonaan taulukollisen palikan paloja
   * @return palikan palat
   */
    public PalikanPala[] getPalat(){
     return tetrisPalikka;   
    }
}
