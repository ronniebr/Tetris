/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ohtyo.Ruudukko;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ronniebr
 */
public class RuudukkoTest {

    public RuudukkoTest() {
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
  public void konstruktoriLuoHalutunRuudukon() {
      Ruudukko ruudukko = new Ruudukko();
      assertEquals(13, ruudukko.getRuudukonKoko());
          
   
                 
  }

}