/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author roudet
 */
public class Orange extends FruitSimple {
	
    public Orange() 
    {
        this.price = 0.5;
        this.country="Espagne";
    }
    
    public Orange(double price, String country) 
    {
	if(country.equals("")){
            this.price=price;
            this.country="Espagne";  //Espagne par défaut
        }  
	else
            initAttributes(price, country);
    }

    public void setPrice(double price){
	this.price=price;
    }
 
    public void setCountry(String country){
	this.country=country;
    }

    @Override
    public String toString(){
        return "Orange";
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
}
