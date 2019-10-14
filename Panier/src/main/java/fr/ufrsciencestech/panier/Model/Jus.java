/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author celine
 */
public class Jus implements Fruit {

    private Fruit f;
    
    /**
     * @return the f
     */
    public Fruit getF() {
        return f;
    }

    /**
     * @param f the f to set
     */
    public void setF(Fruit f) {
        this.f = f;
    }

    public Jus(Fruit f) {
	this.f = f;
    }

    /**
     * Un Jus de fruit ne contient jamais de pepins.
     * @return 
     */
    @Override
    public boolean isSeedless() {
	return true;
    }
    
    @Override
    public String toString() {
	return getF().toString() + "(Jus)";
    }

    @Override
    public double getPrice() {
        //somme des fruits qui composent le jus + 0.5 euro pour la preparation
        double total = 0.5;
        total += getF().getPrice();
        return total;
    }

    @Override
    public String getCountry() {
        return "";  //on ne s'y interesse pas
    }  
}
