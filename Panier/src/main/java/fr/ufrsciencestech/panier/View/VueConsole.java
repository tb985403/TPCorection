/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Model.Panier;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author celine
 */
public class VueConsole implements Observer{
    private String trace;
    
    /**
     * @return the trace
     */
    public String getTrace() {
        return trace;
    }

    /**
     * @param trace the trace to set
     */
    public void setTrace(String trace) {
        this.trace = trace;
    }

    public VueConsole(){
        trace = "Contenance initiale : " + 0;
        System.out.println("Contenance initiale : " + 0);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Panier p = (Panier) o;
        Integer nb = (Integer) p.getSize();
        setTrace("Nouvelle contenance : " + nb.toString());
        System.out.println("Nouvelle contenance : " + nb.toString());
    }
}
