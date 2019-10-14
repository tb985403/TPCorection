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
public class Fraise extends FruitSimple{
    
    public Fraise() 
    {
        this.country="Espagne";
        this.price = 1.5;
    }
    
    public Fraise(double price, String country) 
    {
        if(country.equals("")){
            this.price=price;
            this.country="Espagne";  //Espagne par défaut
        }  
	else
            initAttributes(price, country);
    }

    @Override
    public String toString(){
        return "Fraise";
    }


    @Override
    public boolean isSeedless() {
        return true;
    }
}
