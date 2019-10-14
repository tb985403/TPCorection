/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class AnanasTest extends FruitSimpleTest {
    
    // implementation of the abstract factory methods
    @Override
    FruitSimple createFruit(double price, String country) {
        return new Ananas(price, country);
    }
    
    @Override
    FruitSimple createFruitNull(){
        return null;
    }
    
    /**
     *
     */
    @Before
    @Override
    public void setUp() {
    }
    
    /**
     * Test of constructeur, of class Ananas.
     */
    @Test
    public void testChaineVide() {
        System.out.println("chaine vide");
        Ananas instance = new Ananas(2.0,"");
        String expResult = "Bresil";
        String result = instance.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Ananas.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ananas instance = new Ananas();
        String expResult = "Ananas";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSeedless method, of class Ananas.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        Ananas instance = new Ananas();
        boolean expResult = true;
        boolean result = instance.isSeedless();
        assertEquals(expResult, result);
    }
}
