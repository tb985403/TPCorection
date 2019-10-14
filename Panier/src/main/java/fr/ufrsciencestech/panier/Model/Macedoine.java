/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author celine
 */
public class Macedoine implements Fruit {
    private ArrayList<Fruit> fruits; 
    private boolean seedless;

    //pas possible de créer une macedoine vide
    public Macedoine(Fruit f) {
	fruits = new ArrayList<Fruit>();
        seedless = true;
	this.add(f);
    }

    public void add(Fruit f) {
	getFruits().add(f);
	seedless = seedless && f.isSeedless();
    }

    @Override
    public boolean isSeedless() {
	return seedless;
//	Autre solution :
//  	boolean seedless = true;
//  	Iterator it = _fruits.iterator();
//  	while (it.hasNext()) {
//  	    Fruit f = (Fruit)it.next();
//  	    if (!f.isSeedless()) {
//  		seedless = false;
//  		break; 
//  	    }
//  	}
//  	return seedless;
    }

    @Override
    public String toString() {
        
  	StringBuilder stb = new StringBuilder();
  	Iterator it = fruits.iterator();
        stb.append("Macedoine de ");
  	while (it.hasNext()) {
  	    Fruit f = (Fruit)it.next();
	    stb.append(f.toString());
 	    if (it.hasNext()) {
  		stb.append(", ");
  	    }
  	}
  	return stb.toString();
    }

    @Override
    public double getPrice() {
        //somme des fruits qui la composent + 1.0 euro pour la preparation
        double total= 0.0;
	for(int i = 0 ; i < getFruits().size() ; i++)
            total += getFruits().get(i).getPrice();
        total += 1.0;
	return total;
    }

    @Override
    public String getCountry() {
        return "";  //on ne s'y interesse pas
    }

    /**
     * @return the fruits
     */
    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    /**
     * @param fruits the fruits to set
     */
    public void setFruits(ArrayList<Fruit> fruits) {
        if(!fruits.isEmpty())
            this.fruits = fruits;
    }
}
