/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author celine
 */
public class JusTest {
    Macedoine ban, ile, rouge;
    Banane b1;
    Ananas a1;
    Cerise c1;
    Fraise f1;
    Jus jb1, ja1, jmb, jmi, jmr;
    
    @Before
    public void setUp() {
        b1 = new Banane();
        ban = new Macedoine(b1);
        
        ile = new Macedoine(b1);
        a1 = new Ananas();
        ile.add(a1);
        
        c1 = new Cerise();
        rouge = new Macedoine(c1);
        f1 = new Fraise();
        rouge.add(f1);
        
        jb1 = new Jus(b1);
        ja1 = new Jus(a1);
        jmb = new Jus(ban);
        jmi = new Jus(ile);
        jmr = new Jus(rouge);
    }

    /**
     * Test of isSeedless method, of class Jus.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        
        boolean expResult = true;
        boolean result = jmr.isSeedless();
        assertEquals(expResult, result);
        
        boolean result2 = jb1.isSeedless();
        assertEquals(expResult, result2);
    }

    /**
     * Test of toString method, of class Jus.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "Banane(Jus)";
        String result = jb1.toString();
        assertEquals(expResult, result);
        
        String expResult2 = "Macedoine de Banane(Jus)";
        String result2 = jmb.toString();
        assertEquals(expResult2, result2);
        
        String expResult3 = "Macedoine de Banane, Ananas(Jus)";
        String result3 = jmi.toString();
        assertEquals(expResult3, result3);
    }

    /**
     * Test of getPrice method, of class Jus.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        
        //Mock :
        Fruit mockb = mock(Fruit.class);
        when(mockb.getPrice()).thenReturn(0.5);   //comportement des doublures (stubbing)
        Jus jb = new Jus(mockb);
        double jprice = jb.getPrice();

        //tests d’interaction :
        verify(mockb, times(1)).getPrice();    //getPrice() doit avoir été appelé exactement 1 fois
        assertTrue(jprice == (mockb.getPrice()+0.5));
        
        //jus de banane
        double expResult0 = 0.50 + 0.5;
        double result0 = jb1.getPrice();
        assertEquals(expResult0, result0, 0.0);
        
        //jus de macedoine a 1 fruit
        double expResult1 = 0.50 + 1.0 + 0.5;
        double result1 = jmb.getPrice();
        assertEquals(expResult1, result1, 0.0);
        
        //jus de macedoine a 2 fruits
        double expResult2 = 2.5 + 1.0 + 0.5;
        double result2 = jmi.getPrice();
        assertEquals(expResult2, result2, 0.0);
        
        //jus de macedoine a 2 fruits + 1 macedoine
        ile.add(rouge);
        jmi.setF(ile);
        double expResult3 = 2.5+1.0+2.5+1.0+0.5;
        double result3 = jmi.getPrice();
        assertEquals(expResult3, result3, 0.0);
    }

    /**
     * Test of getCountry method, of class Jus.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        
        String expResult = "";
        String result = jb1.getCountry();
        assertEquals(expResult, result);
        
        String expResult2 = "";
        String result2 = jmi.getCountry();
        assertEquals(expResult2, result2);
    }
}
