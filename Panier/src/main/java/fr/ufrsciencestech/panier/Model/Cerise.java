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
public class Cerise extends FruitSimple{
    
    public Cerise() 
    {
        this.country="France";
        this.price = 1.0;
    }
    
    public Cerise(double price, String country) 
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
        return "Cerise";
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
}
