/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtyo;

import java.util.Scanner;

/**
 *
 * @author ronniebr
 */
public class Demo {

    private static Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {
        char komento;
        Ruudukko ruudukko = new Ruudukko();
        ruudukko.uusiPalikka(); //aloittaa pelin
        System.out.println("Peli on alkanut, liikuta palikkaa alas, vasemalle tai oikealle");
        tulostaTilanne(ruudukko);
        while (ruudukko.onkoPeliLoppu() == false) {
            
            
            komento = lueKomento();
            if (komento == 's') {
                ruudukko.siirraPalikka('a');
                tulostaTilanne(ruudukko);

            } else if (komento == 'a') {
                ruudukko.siirraPalikka('v');
                tulostaTilanne(ruudukko);
            } else if (komento == 'd') {
                ruudukko.siirraPalikka('o');
                tulostaTilanne(ruudukko);
            } else if (komento == 'w'){
                ruudukko.kaannaPalikkaa();
                tulostaTilanne(ruudukko);
            }
            else {
                System.out.println("Virheellinen komento");
            }

        }
        System.out.println("Game over!");



    }

    private static char lueKomento() {
        char komento;
        String rivi = lukija.nextLine();

        if (rivi.length() > 0) {
            komento = rivi.charAt(0);
        } else {
            komento = 'ö';
        }
        return komento;

    }

    private static void tulostaTilanne(Ruudukko ruudukko) {
        System.out.println("pisteet: " + ruudukko.getPisteet());
        for (int i = 0; i < ruudukko.getRuudukonKoko(); i++) {
            for (int j = 0; j < ruudukko.getRuudukonMatriisi()[i].length; j++) {
                System.out.print(ruudukko.getRuudukonMatriisi()[i][j]);
            }
            System.out.println();
        }

    }
}
