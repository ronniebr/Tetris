/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronniebr
 */
import ohtyo.Ruudukko;
import ohtyo.Palikka;
import ohtyo.PalikanPala;
        
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PalikkaTest {
    public PalikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
  @Test
  public void palikkaSiirto() {
      Ruudukko ruudukko = new Ruudukko();
      ruudukko.uusiPalikka();
      System.out.println("x: " +ruudukko.kahvaAktiiviseenPalikkaan().getPalat()[0].getxkoordinaatti() + 
                  " y: " + ruudukko.kahvaAktiiviseenPalikkaan().getPalat()[0].getykoordinaatti());
      for (int rivi=0; rivi<ruudukko.getRuudukonMatriisi().length; ++rivi)
      for (int sarake=0; sarake<ruudukko.getRuudukonMatriisi()[rivi].length; ++sarake)
          System.out.println();
 
      for(int i = 0; i < 1000; i++){
          ruudukko.siirraPalikka('a');
          System.out.println("x: " +ruudukko.kahvaAktiiviseenPalikkaan().getPalat()[0].getxkoordinaatti() + 
                  " ,y: " + ruudukko.kahvaAktiiviseenPalikkaan().getPalat()[0].getykoordinaatti());
          
      }
      
      assertFalse("", ruudukko.siirraPalikka('a'));
      
  }

}
    

