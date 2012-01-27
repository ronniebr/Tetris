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
  public void palikkaRuudukkoon() {
      Ruudukko ruudukko = new Ruudukko();
      ruudukko.uusiPalikka();
 
      
      assertTrue("", ruudukko.kahvaAktiiviseenPalikkaan().siirra('a', ruudukko));
      
  }

}
    

