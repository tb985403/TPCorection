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
public class Ananas extends FruitSimple{
    
    public Ananas() 
    {
        this.price=2.0;
        this.country="Bresil";
    }
    
    public Ananas(double price, String country) 
    {
	if(country.equals("")){
            this.price=price;
            this.country="Bresil";  //Bresil par défaut
        }  
	else
            initAttributes(price, country);
    }
    
    @Override
    public String toString(){
        return "Ananas";
    }

    @Override
    public boolean isSeedless() {
        return true;
    }
}
