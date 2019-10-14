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
public abstract class FruitSimple implements Fruit {
    protected double price;
    protected String country;
    
    @Override
    public double getPrice(){
	return price;
    }
    @Override
    public String getCountry(){
	return country;
    }
    
    protected void initAttributes(double price, String country){
        if(price < 0){
            this.price = -price;  //ou = 0
            this.country = country;
            //ou throw new Exception();
            //ou gestion avec JML
	} 
	else
        {
            this.price = price;
            this.country = country;
        }
    }
    
    @Override
    public boolean equals(Object o){
        if(o != null && getClass() == o.getClass()){
            FruitSimple fs = (FruitSimple) o;
            return (price == fs.price && country.equals(fs.country));
        }
        return false;
    }

    @Override
    public abstract boolean isSeedless();
    @Override
    public abstract String toString();
}
