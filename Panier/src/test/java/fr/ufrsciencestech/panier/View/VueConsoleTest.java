/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Model.PanierVideException;
import fr.ufrsciencestech.panier.Model.PanierPleinException;
import fr.ufrsciencestech.panier.Model.Panier;
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
public class VueConsoleTest {
    VueConsole vuec, vuecmock;
    Panier p;
    
    public VueConsoleTest() {
    }
    
    @Before
    public void setUp() {
        vuecmock = new VueConsole();
        vuec = new VueConsole();
        p = new Panier(2);
    }

    /**
     * Test of update method, of class VueConsole.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     * @throws fr.ufrsciencestech.panier.Model.PanierVideException
     */
    @Test
    public void testUpdate() throws PanierPleinException, PanierVideException {
        System.out.println("update");
        //mock
        Panier mockp2 = mock(Panier.class);
        Panier mockp0 = mock(Panier.class);
        when(mockp2.getSize()).thenReturn(2);   //comportement des doublures (stubbing)
        when(mockp0.getSize()).thenReturn(0); 
        //tests d’interaction :
        verify(mockp2, times(0)).getSize();    //getSize() doit avoir été appelé exactement 0 fois
        assertEquals(vuecmock.getTrace(), "Contenance initiale : " + 0);
        vuecmock.update(mockp2, null);
        verify(mockp2, times(1)).getSize(); 
        assertEquals(vuecmock.getTrace(), "Nouvelle contenance : " + 2);
        
        vuecmock.update(mockp0, null);
        verify(mockp0, times(1)).getSize(); 
        assertEquals(vuecmock.getTrace(), "Nouvelle contenance : " + 0);

        //sans les mocks
        assertEquals(vuec.getTrace(), "Contenance initiale : " + 0);
        p.add();
        assertEquals(vuec.getTrace(), "Contenance initiale : " + 0);
        p.remove();
        
        //si on ajoute la vue comme observateur du panier, elle se met à jour correctement
        p.addObserver(vuec);
        p.add();
        assertEquals(vuec.getTrace(), "Nouvelle contenance : " + 1);
        p.add();
        assertEquals(vuec.getTrace(), "Nouvelle contenance : " + 2);
    }
}
