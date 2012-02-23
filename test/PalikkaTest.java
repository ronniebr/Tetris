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

 
      for(int k = 0; k < 200; k++){
          System.out.println();
          ruudukko.siirraPalikka('a');
           System.out.println("x: " +ruudukko.kahvaAktiiviseenPalikkaan().getPalat()[0].getxkoordinaatti() + 
                  " ,y: " + ruudukko.kahvaAktiiviseenPalikkaan().getPalat()[0].getykoordinaatti());
          for(int i=0; i< ruudukko.getRuudukonKoko(); i++){
          for(int j= 0; j < ruudukko.getRuudukonMatriisi()[i].length; j++){
          System.out.print(ruudukko.getRuudukonMatriisi()[i][j]);
          }
          System.out.println();
          
      }
      
          
         
                  
          
          
      }
      for(int i=0; i< ruudukko.getRuudukonKoko(); i++){
          for(int j= 0; j < ruudukko.getRuudukonMatriisi()[i].length; j++){
          System.out.print(ruudukko.getRuudukonMatriisi()[i][j]);
          }
          System.out.println();
          
      }
      
      
      assertFalse("", ruudukko.siirraPalikka('a'));
      
  }

}
    

