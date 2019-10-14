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
public class Banane extends FruitSimple{
    
    public Banane() 
    {
        this.country="France";
        this.price = 0.50;
    }
    
    public Banane(double price, String country) 
    {
        if(country.equals("")){
            this.price=price;
            this.country="France";  //France par défaut
        }  
	else
            initAttributes(price, country);
    }

    @Override
    public String toString(){
        return "Banane";
    }

    @Override
    public boolean isSeedless() {
        return true;
    }
}
