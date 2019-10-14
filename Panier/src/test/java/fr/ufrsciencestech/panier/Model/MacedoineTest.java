/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

import java.util.ArrayList;
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
public class MacedoineTest {
    Macedoine ban, ile, rouge;
    Banane b1;
    Ananas a1;
    Cerise c1;
    Fraise f1;
    Jus jo;

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
        
        jo = new Jus(new Orange());
    }

    /**
     * Test of add method, of class Macedoine.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        
        //Macedoine a 1 fruit
        Fruit f = b1;
        Macedoine instance = ban;  
        instance.add(f);
        assertTrue(instance.getFruits().size() == 2);
        
        //Macedoine a 2 fruits, on ajoute un fruit
        Fruit f2 = c1;
        ile.add(f2);
        assertTrue(ile.getFruits().size() == 3);
        
        //Macedoine a 3 fruits, on ajoute une macedoine
        ile.add(rouge);
        assertTrue(ile.getFruits().size() == 4);
    }

    /**
     * Test of isSeedless method, of class Macedoine.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        //mock
        Fruit mockb = mock(Fruit.class);
        Fruit mockc = mock(Fruit.class);
        Fruit mocko = mock(Fruit.class);
        when(mockb.isSeedless()).thenReturn(true);   //comportement des doublures (stubbing)
        when(mockc.isSeedless()).thenReturn(false); 
        when(mocko.isSeedless()).thenReturn(false); 
        Macedoine mb = new Macedoine(mockb);
        Macedoine mcomp2 = new Macedoine(mockb);
        mcomp2.add(mockc);
        Macedoine mcomp3 = new Macedoine(mockb);
        mcomp3.add(mockc);
        mcomp3.add(mocko);

        //tests d’interaction :
        verify(mockb, times(3)).isSeedless();    //isSeedless() doit avoir été appelé exactement 3 fois
        verify(mockc, times(2)).isSeedless();    //Attention à l'operateur && !!!
        verify(mocko, times(0)).isSeedless(); 
        assertTrue(mb.isSeedless());
        assertFalse(mcomp2.isSeedless());
        assertFalse(mcomp3.isSeedless());
        
        
        //test avec une macedoine ss pepins
        boolean expResult = true;
        boolean result = ile.isSeedless();
        assertEquals(expResult, result);
        
        //test avec une macedoine avec pepins
        boolean expResult2 = false;
        boolean result2 = rouge.isSeedless();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of toString method, of class Macedoine.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        //macedoine vide
        Macedoine instance = new Macedoine(c1);
        String expResult = "Macedoine de Cerise";
        String result = instance.toString();
        assertEquals(expResult, result);

        //macedoine a 2 fruits
        String expResult2 = "Macedoine de Banane, Ananas";
        String result2 = ile.toString();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getPrice method, of class Macedoine.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        //Mock :
        Fruit mockb = mock(Fruit.class);
        when(mockb.getPrice()).thenReturn(0.5);   //comportement des doublures (stubbing)
        Macedoine mb = new Macedoine(mockb);
        double mprice = mb.getPrice();

        //tests d’interaction :
        verify(mockb, times(1)).getPrice();    //getPrice() doit avoir été appelé exactement 1 fois
        assertTrue(mprice == (mockb.getPrice()+1.0));
        
        //macedoine a 1 fruit
        Macedoine instance = new Macedoine(b1);
        double expResult = 0.50 + 1.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        
        //macedoine a 2 fruits
        double expResult2 = 2.5+1.0;
        double result2 = ile.getPrice();
        assertEquals(expResult2, result2, 0.0);
        
        //macedoine a 2 fruits + 1 macedoine
        ile.add(rouge);
        double expResult3 = 2.5+1.0+2.5+1.0;
        double result3 = ile.getPrice();
        assertEquals(expResult3, result3, 0.0);
        
        //macedoine a 2 fruits + 1 macedoine + 1jus
        ile.add(jo);
        double expResult4 = 2.5+1.0+2.5+1.0+0.5+0.5;
        double result4 = ile.getPrice();
        assertEquals(expResult4, result4, 0.0);
    }

    /**
     * Test of getCountry method, of class Macedoine.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        
        String expResult = "";
        String result = ile.getCountry();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of setFruits method, of class Macedoine.
     */
    @Test
    public void testSetFruits() {
        System.out.println("setFruits");
        
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        ile.setFruits(fruits);
        assertTrue(ile.getFruits().size() == 2);
        
        fruits.add(c1);
        ile.setFruits(fruits);
        assertTrue(ile.getFruits().size() == 1);
    }
    
}
